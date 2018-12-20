package com.pigfly.sell.dao;

import com.pigfly.sell.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductInfoStatus() {

    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12845574");
        productInfo.setProductName("蛋炒饭");
        productInfo.setProductPrice(new BigDecimal(18.3));
        productInfo.setProductStock(200);
        productInfo.setProductDescription("美味的蛋炒饭");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setCategoryType(2);
        productInfo.setProductStatus(0);

        ProductInfo productInfo1 = repository.save(productInfo);
        System.out.println(productInfo1.toString());
    }
}