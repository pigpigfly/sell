package com.pigfly.sell.controller;


import com.pigfly.sell.VO.ProductInfoVO;
import com.pigfly.sell.VO.ProductVO;
import com.pigfly.sell.VO.ResultVO;
import com.pigfly.sell.service.ProductCategoryService;
import com.pigfly.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
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
       ResultVO resultVO = new ResultVO();
       ProductVO productVO = new ProductVO();
       ProductInfoVO productInfoVO1 = new ProductInfoVO();
       ProductInfoVO productInfoVO2 = new ProductInfoVO();
       List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
       resultVO.setCode(0);
       resultVO.setMsg("成功");
       resultVO.setData(productVO);
       productVO.setCategoryName("热销榜");
       productVO.setCategoryType(11);
       productInfoVO1.setProductId("123213123123");
       productInfoVO1.setProductName("皮蛋粥");
       productInfoVO1.setProductPrice(new BigDecimal(12.5));
       productInfoVO1.setProductDescription("特别好吃");
       productInfoVO1.setProductIcon("http://xxxxxxx.jpg");
       productInfoVO2.setProductId("123213123123");
       productInfoVO2.setProductName("蛋炒饭");
       productInfoVO2.setProductPrice(new BigDecimal(15.5));
       productInfoVO2.setProductDescription("特别好吃2");
       productInfoVO2.setProductIcon("http://xxxxxxx.jpg");
       productInfoVOList.add(productInfoVO1);
       productInfoVOList.add(productInfoVO2);
       productVO.setProductInfoVOList(productInfoVOList);
       return resultVO;
    }
}
