package com.pigfly.sell.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@DynamicUpdate
public class OrderMaster {
    /** 订单编号 */
    @Id
    @Column(name="order_id")
    private String orderId;
    /** 顾客姓名 */
    @Column(name="buyer_name")
    private String buyerName;
    /** 顾客电话 */
    @Column(name="buyer_phone")
    private String buyerPhone;
    /** 顾客地址 */
    @Column(name="buyer_address")
    private String buyerAddress;
    /** 顾客openid */
    @Column(name="buyer_openid")
    private String buyerOpenId;
    /** 订单数量 */
    @Column(name="order_acount")
    private BigDecimal OrderAcount;
    /** 订单状态 */
    @Column(name="order_status")
    private Integer OrderStatus;
    /** 支付状态 */
    @Column(name="pay_status")
    private Integer payStatus;

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

    public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenId, BigDecimal orderAcount, Integer orderStatus, Integer payStatus) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenId = buyerOpenId;
        OrderAcount = orderAcount;
        OrderStatus = orderStatus;
        this.payStatus = payStatus;
    }

    public OrderMaster() {
    }

    @Override
    public String toString() {
        return "OrderMaster{" +
                "orderId='" + orderId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", buyerAddress='" + buyerAddress + '\'' +
                ", buyerOpenId='" + buyerOpenId + '\'' +
                ", OrderAcount=" + OrderAcount +
                ", OrderStatus=" + OrderStatus +
                ", payStatus=" + payStatus +
                '}';
    }
}
