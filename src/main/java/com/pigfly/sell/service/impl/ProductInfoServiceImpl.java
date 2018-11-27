package com.pigfly.sell.service.impl;

import com.pigfly.sell.dao.ProductInfoRepository;
import com.pigfly.sell.entity.ProductInfo;
import com.pigfly.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository repository;
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).get();

    }

    @Override
    public List<ProductInfo> findUpAll() {
        return null;
    }

    @Override
    public List<ProductInfo> findAll(Pageable pageable) {
        return null;
    }
}
