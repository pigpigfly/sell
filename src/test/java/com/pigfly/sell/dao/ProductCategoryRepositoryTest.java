package com.pigfly.sell.dao;

import com.pigfly.sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void testFind(){
        ProductCategory productCategory = productCategoryRepository.findById(1).get();

        System.out.println(productCategory);
    }

    @Test
    public void testSave(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("最热榜");
        productCategory.setCategoryType(2);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void testUpdate(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(9);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(11);
        productCategoryRepository.save(productCategory);
    }
}