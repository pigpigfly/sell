package com.pigfly.sell.controller;


import com.pigfly.sell.VO.ProductInfoVO;
import com.pigfly.sell.VO.ProductVO;
import com.pigfly.sell.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @GetMapping("/list")
    public ResultVO list(){
       ResultVO resultVO = new ResultVO();
        ProductVO productVO = new ProductVO();
        List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
       resultVO.setCode(0);
       resultVO.setMsg("成功");
       resultVO.setData(productVO);
       productVO.setCategoryName("热销榜");
       productVO.setCategoryType(11);
       productVO.setProductInfoVOList(productInfoVOList);
        return resultVO;
    }
}
