package com.pigfly.sell.enums;

/**
 * 支付状态枚举类型
 */
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"成功支付"),

    ;

    private Integer code;

    private  String message;

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

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    PayStatusEnum() {
    }
}
