package com.zqq.entity;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
public class Users {

    private String mac;
    private String id;
    private String name;
    private String password;
    private int age;
    private String gendar;
    private String intr="";

    public Users() {
    }

    public Users(String mac, String id, String name, String password, int age, String gendar, String intr) {
        this.mac = mac;
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.gendar = gendar;
        this.intr = intr;
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
