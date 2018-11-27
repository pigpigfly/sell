package com.pigfly.sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pigfly.sell.entity.ProductInfo;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductInfoStatus(Integer productStatus);
}
