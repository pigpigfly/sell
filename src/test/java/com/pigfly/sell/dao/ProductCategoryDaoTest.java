package com.pigfly.sell.dao;

import com.pigfly.sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testFind(){
        ProductCategory productCategory = productCategoryDao.findById(1).get();

        System.out.println(productCategory);
    }

    @Test
    public void testSave(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(10);
        productCategoryDao.save(productCategory);
    }

    @Test
    public void testUpdate(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("男生最爱");
        productCategoryDao.save(productCategory);
    }
}