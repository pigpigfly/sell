package com.pigfly.sell.utils;

import com.pigfly.sell.VO.ResultVO;

public class ResultVOUtil {
    /*
    1、返回成功结果
     */
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }
    /*
    2、返回失败结果
     */
    public static ResultVO fail(Integer code,String msg){
      ResultVO resultVO = new ResultVO();
      resultVO.setCode(code);
      resultVO.setMsg(msg);
      return resultVO;
    }
}
