package com.zqq.entity.reponse;

import com.zqq.enums.Code;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
public class ApiResult {

    private String code;
    private String message;

    public ApiResult(Code code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }


    public ApiResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
