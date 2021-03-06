package com.zqq.entity;

import java.util.Date;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
public class Users {

    private String mac;
    private String id;
    private String name;
    private String password;
    private String phone;
    private Date birthday;
    private int age;
    private String gendar;
    private String intr="";
    private String time;

    public Users() {
    }


    public Users(String mac, String id, String name, String password, String phone, Date birthday, int age, String gendar, String intr, String time) {
        this.mac = mac;
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.birthday = birthday;
        this.age = age;
        this.gendar = gendar;
        this.intr = intr;
        this.time = time;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGendar() {
        return gendar;
    }

    public void setGendar(String gendar) {
        this.gendar = gendar;
    }

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }
}
