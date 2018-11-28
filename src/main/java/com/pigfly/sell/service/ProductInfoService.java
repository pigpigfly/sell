package com.pigfly.sell.service;

import com.pigfly.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存商品信息
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    //加库存


    //减库存


}
