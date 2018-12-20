package com.pigfly.sell.dao;

import com.pigfly.sell.entity.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void findByBuyerOpenId() {
        PageRequest request = new PageRequest(0,1);

        System.out.println( orderMasterRepository.findByBuyerOpenId("11011011",request));
    }

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("21312322");
        orderMaster.setBuyerName("张四");
        orderMaster.setBuyerPhone("18702374353");
        orderMaster.setBuyerAddress("天津市和平区赤峰道63号");
        orderMaster.setBuyerOpenId("11011012");
        orderMaster.setOrderAcount(new BigDecimal(12));
        orderMaster.setOrderStatus(0);
        orderMaster.setPayStatus(0);



        System.out.println(orderMasterRepository.save(orderMaster));


    }
}