package com.zqq.entity;

import java.util.Date;

/**
 * Created by zhuqingquan on 2017/4/10.
 */
public class Admin {
    private String id;
    private String password;
    private Date time;

    public Admin() {
    }

    public Admin(String id, String password, Date time) {
        this.id = id;
        this.password = password;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
