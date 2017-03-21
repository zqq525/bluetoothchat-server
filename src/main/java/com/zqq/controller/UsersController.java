package com.zqq.controller;

import com.zqq.entity.Users;
import com.zqq.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@RestController
@EnableAutoConfiguration
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;

    @PostMapping(value = "/users")
    public String addUsers(@RequestBody Users users) {
        usersMapper.insertUsers(users);
        return "success";
    }
}
