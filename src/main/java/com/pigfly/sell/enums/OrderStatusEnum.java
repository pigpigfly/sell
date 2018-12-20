package com.pigfly.sell.enums;

/**
 * 订单状态枚举类型
 */
public enum OrderStatusEnum {
    NEW(0,"新订单"),
        FINISHED(1,"完结订单"),
            CANCEL(2,"取消订单")
                ;
    private Integer code;

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

    OrderStatusEnum(Integer code, String message){
        this.code=code;
        this.message=message;
    }

    OrderStatusEnum() {
    }
}
