package com.pigfly.sell.service;

import com.pigfly.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryService{
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
    ProductCategory save(ProductCategory productCategory);
}

