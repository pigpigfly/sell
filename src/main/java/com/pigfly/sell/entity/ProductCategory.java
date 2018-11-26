package com.pigfly.sell.entity;

import javax.persistence.*;
import java.util.Date;

/**
 *  类目
 */
@Entity
public class ProductCategory {
    /** 类目id */
    @Id
    @GeneratedValue
   private Integer categoryId;
    /** 类目名字 */
   private String categoryName;
    /** 类目编号 */
   private Integer categoryType;
    /** 创建日期 */
   private Date createTime;
    /** 更新日期 */
   private Date updateTime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /** 无参构造函数 */
    public ProductCategory() {
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}
