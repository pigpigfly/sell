package com.pigfly.sell.service.impl;

import com.pigfly.sell.dao.OrderDetailRepository;
import com.pigfly.sell.dao.OrderMasterRepository;
import com.pigfly.sell.dto.OrderDTO;
import com.pigfly.sell.entity.OrderDetail;
import com.pigfly.sell.entity.OrderMaster;
import com.pigfly.sell.entity.ProductInfo;
import com.pigfly.sell.enums.ResultEnum;
import com.pigfly.sell.exception.SellException;
import com.pigfly.sell.service.OrderService;
import com.pigfly.sell.service.ProductInfoService;
import com.pigfly.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAcount = new BigDecimal(BigInteger.ZERO);

        //1、查询商品（数量、价格）
        for(OrderDetail orderDetail: orderDTO.getOrderDetailList()){
          ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if(productInfo==null){
               throw new SellException(ResultEnum.product_not_exist);
            }

            //2、计算总价
            orderAcount =  orderDetail.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAcount);

            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);

        }
        //3、写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAcount(orderAcount);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMasterRepository.save(orderMaster);


        //4、扣库存


        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
