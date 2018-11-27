package com.pigfly.sell.service.impl;

import com.pigfly.sell.dao.ProductCategoryRepository;
import com.pigfly.sell.entity.ProductCategory;
import com.pigfly.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    /**
     * 引入DAO
     */
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryRepository.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypelist) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypelist);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
