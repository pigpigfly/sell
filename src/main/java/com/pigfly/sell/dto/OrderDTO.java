package com.pigfly.sell.dto;

import com.pigfly.sell.entity.OrderDetail;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {
    /** 订单编号 */
    private String orderId;
    /** 顾客姓名 */
    private String buyerName;
    /** 顾客电话 */
    private String buyerPhone;
    /** 顾客地址 */
    private String buyerAddress;
    /** 顾客openid */
    private String buyerOpenId;
    /** 订单数量 */
    private BigDecimal OrderAcount;
    /** 订单状态 */
    private Integer OrderStatus;
    /** 支付状态 */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerOpenId() {
        return buyerOpenId;
    }

    public void setBuyerOpenId(String buyerOpenId) {
        this.buyerOpenId = buyerOpenId;
    }

    public BigDecimal getOrderAcount() {
        return OrderAcount;
    }

    public void setOrderAcount(BigDecimal orderAcount) {
        OrderAcount = orderAcount;
    }

    public Integer getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        OrderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public OrderDTO(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenId, BigDecimal orderAcount, Integer orderStatus, Integer payStatus, List<OrderDetail> orderDetailList) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenId = buyerOpenId;
        OrderAcount = orderAcount;
        OrderStatus = orderStatus;
        this.payStatus = payStatus;
        this.orderDetailList = orderDetailList;
    }

    public OrderDTO() {
    }

}
