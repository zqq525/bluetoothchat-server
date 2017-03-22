package com.zqq.mapper;

import com.zqq.entity.Users;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import static org.junit.Assert.*;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@EnableAutoConfiguration
public class UsersMapperTest {

    @Autowired
    private UsersMapper usersMapper;
    @Test
    public void insetUsersTest(){
        Users users = new Users("123", "123", "zhuqingquan", "123456", 23, "man", "hello world!");
        usersMapper.insertUsers(users);
    }



}