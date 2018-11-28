package com.pigfly.sell.service.impl;

import com.pigfly.sell.entity.ProductInfo;
import com.pigfly.sell.enums.ProductStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoServiceImpl;

    @Test
    public void findOne() {
       ProductInfo  p = productInfoServiceImpl.findOne("12345678");
       System.out.println(p.toString());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> p = productInfoServiceImpl.findUpAll();
    }

    @Test
    public void findAll() {

    }

    @Test
    public void save(){

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12345678");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(12.3));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("美味的粥");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setCategoryType(11);
        productInfo.setProductStatus(0);

        ProductInfo productInfo1 = productInfoServiceImpl.save(productInfo);
        System.out.println(productInfo1.toString());

    }
}