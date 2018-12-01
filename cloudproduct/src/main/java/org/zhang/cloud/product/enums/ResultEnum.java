package org.zhang.cloud.product.enums;

import jdk.nashorn.internal.objects.annotations.Getter;


public enum ResultEnum {
    PRODUCT_NOT_EXSIT(1, "商品不存在"),
    PRODUCT_STORCK_ERROR(2, "库存有误");

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
