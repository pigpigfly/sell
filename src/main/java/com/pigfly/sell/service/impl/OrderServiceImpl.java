package com.pigfly.sell.service.impl;

import com.pigfly.sell.dao.OrderDetailRepository;
import com.pigfly.sell.dao.OrderMasterRepository;
import com.pigfly.sell.dto.CartDTO;
import com.pigfly.sell.dto.OrderDTO;
import com.pigfly.sell.entity.OrderDetail;
import com.pigfly.sell.entity.OrderMaster;
import com.pigfly.sell.entity.ProductInfo;
import com.pigfly.sell.enums.OrderStatusEnum;
import com.pigfly.sell.enums.PayStatusEnum;
import com.pigfly.sell.enums.ResultEnum;
import com.pigfly.sell.exception.SellException;
import com.pigfly.sell.service.OrderService;
import com.pigfly.sell.service.ProductInfoService;
import com.pigfly.sell.utils.KeyUtil;
import com.pigfly.sell.utils.OrderDTO2OrderMasterConverter;
import com.pigfly.sell.utils.OrderMaster2OrderDTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAcount = new BigDecimal(BigInteger.ZERO);
        List<CartDTO> cartDTOList = new ArrayList<>();
        //1、查询商品（数量、价格）
        for(OrderDetail orderDetail: orderDTO.getOrderDetailList()){
          ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if(productInfo==null){
               throw new SellException(ResultEnum.product_not_exist);
            }

            //2、计算总价   yuanlai  orderDetail
            orderAcount =  productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAcount);
            //订单详情入库
            BeanUtils.copyProperties(productInfo,orderDetail);

            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);

            orderDetailRepository.save(orderDetail);

            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());

            cartDTOList.add(cartDTO);

        }
        //3、写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);

        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAcount(orderAcount);

        orderMasterRepository.save(orderMaster);


        //4、扣库存

        productInfoService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        //1、查找订单信息
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        //2、判断订单信息是否存在
        if(orderMaster == null){
            throw  new SellException(ResultEnum.order_not_exist);
        }
        //3、查找订单详情信息
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        //4、判断订单详情信息是否存在
        if(CollectionUtils.isEmpty(orderDetailList)){
            throw  new SellException(ResultEnum.orderdetail_not_exist);
        }
        //5、将订单信息拼接成订单DTO返回
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        //1、通过openid,pageable查找订单信息
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenId(buyerOpenId,pageable);
        //2、将list<orderMaster>转换成List<orderDTO>
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());
        //3、将List<orderDTO>转换成Page<OrderDTO>
        Page<OrderDTO> orderDTOPage = new PageImpl<OrderDTO>(orderDTOList,pageable,orderMasterPage.getTotalElements());
        return orderDTOPage;
    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        //1、判断订单状态
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
             log.error("【取消订单】订单状态不正确,orderId={},orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
             throw new SellException(ResultEnum.order_status_error);
        }
        //2、修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDTO,orderMaster);

        OrderMaster updateResult =  orderMasterRepository.save(orderMaster);
        if(updateResult == null){
            log.error("【取消订单】更新失败,orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.order_update_fail);
        }
        //3、返还库存，订单作废
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【取消订单】订单中无商品详情,orderDTO={}",orderDTO);
            throw new SellException(ResultEnum.order_detail_empty);
        }
        List<OrderDetail> orderDetailList= orderDTO.getOrderDetailList();
        List<CartDTO> cartDTOList = new ArrayList<CartDTO>();

        for (OrderDetail orderDetail:orderDetailList) {
             CartDTO cartDTO = new CartDTO();
             cartDTO.setProductId(orderDetail.getProductId());
             cartDTO.setProductQuantity(orderDetail.getProductQuantity());
             cartDTOList.add(cartDTO);
        }
        productInfoService.increaseStock(cartDTOList);
        //4、若已支付，则需要退款
        if (orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())){
            //TODO
        }
        return orderDTO;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        //1、判断订单状态
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
              logger.error("【完结订单】订单状态不正确,orderId={},orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
         //     throw  new SellException(ResultEnum);
        }
        //2、修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if(updateResult == null){
            logger.error("【完结订单】更新失败,orderMaster={}",orderMaster);
         //     throw  new SellException(ResultEnum);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
