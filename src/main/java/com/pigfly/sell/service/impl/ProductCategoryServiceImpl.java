package com.pigfly.sell.service.impl;

import com.pigfly.sell.dao.ProductCategoryDao;
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
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypelist) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypelist);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
