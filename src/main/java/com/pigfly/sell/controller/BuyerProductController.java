package com.pigfly.sell.controller;


import com.pigfly.sell.VO.ProductInfoVO;
import com.pigfly.sell.VO.ProductVO;
import com.pigfly.sell.VO.ResultVO;
import com.pigfly.sell.entity.ProductCategory;
import com.pigfly.sell.entity.ProductInfo;
import com.pigfly.sell.service.ProductCategoryService;
import com.pigfly.sell.service.ProductInfoService;
import com.pigfly.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVO list(){
        //1、查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2、查询类目
        List<Integer> categoryTypeList = new ArrayList<>();

        for (ProductInfo productInfo : productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //3、数据拼装
        List<ProductVO> productVOList= new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO  = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
       return ResultVOUtil.success(productVOList);
    }
}
