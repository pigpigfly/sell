package com.pigfly.sell.enums;

/**
 * 商品状态枚举类型
 */
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架")
    ;
    /**状态编码 */
    private Integer code;
    /**状态编码说明 */
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ProductStatusEnum() {
    }
}
