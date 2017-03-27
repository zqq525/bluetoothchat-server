package com.zqq.enums;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
public enum Code {
    SUCCESS("200","成功"),
    FAILURE("500","失败"),
    EXITS("201", "已存在");


    Code(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private String code;
    private String message;
}
