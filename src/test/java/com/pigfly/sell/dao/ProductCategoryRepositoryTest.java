package com.pigfly.sell.dao;

import com.pigfly.sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void testFind(){
        ProductCategory productCategory = productCategoryRepository.findById(9).get();

        System.out.println(productCategory);
    }

    @Test
    public void testFindByCategoryTypeIn(){
        List<Integer> lists = Arrays.asList(11,2,32);
        List<ProductCategory> result =  productCategoryRepository.findByCategoryTypeIn(lists);
        for(ProductCategory pc : result){
            System.out.println("id："+pc.getCategoryId());
            System.out.println("name："+pc.getCategoryName());
            System.out.println("type："+pc.getCategoryType());

        }
    }

    @Test
    public void testSave(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("情侣套餐");
        productCategory.setCategoryType(32);
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