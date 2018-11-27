package com.pigfly.sell.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 *  类目
 */
@Entity
@DynamicUpdate
public class ProductCategory {
    /** 类目id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer categoryId;
    /** 类目名字 */
   private String categoryName;
    /** 类目编号 */
   private Integer categoryType;



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
