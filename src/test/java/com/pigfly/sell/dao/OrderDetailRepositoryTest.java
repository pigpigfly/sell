package com.pigfly.sell.dao;

import com.pigfly.sell.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Test
    public void findByOrderId() {
    }

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("532561455432");
        orderDetail.setOrderId("21312323");
        orderDetail.setProductId("12345678");
        orderDetail.setProductName("皮蛋瘦肉粥");
        orderDetail.setProductPrice(new BigDecimal(12.3));
        orderDetail.setProductIcon("http://xxxxx.jpg");
        orderDetail.setProductQuantity(100);
        System.out.println(orderDetailRepository.save(orderDetail));


    }
}