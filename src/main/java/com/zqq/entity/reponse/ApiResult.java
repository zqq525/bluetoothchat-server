package com.zqq.entity.reponse;

import com.zqq.entity.Users;
import com.zqq.enums.Code;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
public class ApiResult {

    private String code;
    private String message;
    private Users users;

    public ApiResult(Code code) {
        this(code, null);
    }


    public ApiResult(Code code, Users users) {
        this.code = code.getCode();
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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
