package org.zhang.cloud.product.exception;

import org.zhang.cloud.product.enums.ResultEnum;

/**
 * @Auther: zhang
 * @Date: 2018/12/1 23:33
 * @Description:
 */

public class ProductException extends RuntimeException {
    private int code;

    public ProductException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = code;
    }
}
