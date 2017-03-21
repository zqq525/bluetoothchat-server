package com.zqq.entity;

import org.springframework.context.annotation.Bean;

/**
 * Created by zhuqingquan on 2017/3/21.
 */

public class Confirm {
    private String id;
    private String password;

    public Confirm(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Confirm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
