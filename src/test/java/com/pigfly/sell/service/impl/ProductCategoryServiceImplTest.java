package com.pigfly.sell.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryServiceImpl productCategoryServiceImpl;
    @Test
    public void findOne() {

        System.out.println(productCategoryServiceImpl.findOne(9));
    }

    @Test
    public void findAll() {
        System.out.println(productCategoryServiceImpl.findAll());
    }

    @Test
    public void findByCategoryTypeIn() {

    }

    @Test
    public void save() {
    }
}