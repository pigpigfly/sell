package com.pigfly.sell.service;

import com.pigfly.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryService{
    /**
     * 根据类目ID查找类目信息
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查找所有类目信息
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 根据类目编号查找类目信息
     * @param categoryType
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);

    /**
     * 保存类目信息
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}

