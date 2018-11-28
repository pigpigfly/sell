package com.pigfly.sell.service;

import com.pigfly.sell.entity.ProductInfo;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductInfoService {
    /**
     * 根据商品ID查找商品
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查找所有上架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查找所有商品
     * @param pageable
     * @return
     */
    List<ProductInfo> findAll(Pageable pageable);

    /**
     *加库存、减库存
     */
    ProductInfo save(ProductInfo productInfo);
}
