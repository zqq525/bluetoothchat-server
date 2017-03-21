package com.zqq.controller;

import com.zqq.entity.Users;
import com.zqq.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/users")
    public String addUsers(@RequestBody Users users) {
        if(usersService.addUsers(users)!=false) {
            return "index";
        }else {
            return "failure";
        }
    }
}
