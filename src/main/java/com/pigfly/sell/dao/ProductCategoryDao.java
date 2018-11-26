package com.pigfly.sell.dao;

import com.pigfly.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

}
