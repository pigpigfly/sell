package com.pigfly.sell.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 商品信息
 */
@Entity
@DynamicUpdate
public class ProductInfo {
    /**商品id */
    @Id
    @Column(name="product_id")
    private String productId;
    /**商品名称*/
    @Column(name="product_name")
    private String productName;
    /**商品价格*/
    @Column(name="product_price")
    private BigDecimal productPrice;
    /**商品库存*/
    @Column(name="product_stock")
    private Integer productStock;
    /**商品描述*/
    @Column(name="product_description")
    private String productDescription;
    /**商品图片*/
    @Column(name="product_icon")
    private String productIcon;
    /**类目编号*/
    @Column(name="category_type")
    private Integer categoryType;
    /**商品状态，0 正常 1 下架*/
    @Column(name="product_status")
    private Integer productStatus;
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public ProductInfo() {
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                ", productDescription='" + productDescription + '\'' +
                ", productIcon='" + productIcon + '\'' +
                ", categoryType=" + categoryType +
                ", productStatus=" + productStatus +
                '}';
    }
}
