package com.zqq.controller;

import com.zqq.entity.Confirm;
import com.zqq.entity.Users;
import com.zqq.entity.reponse.ApiResult;
import com.zqq.enums.Code;
import com.zqq.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 用户注册
     * @param users
     * @return
     */
    @PostMapping(value = "/")
    public ApiResult addUsers(@RequestBody Users users) {
        if(usersService.addUsers(users)) {
            return new ApiResult(Code.SUCCESS);
        }else {
            return new ApiResult(Code.FAILURE);
        }
    }

    /**
     * 登录验证
     * @param confirm
     * @return
     */
    @PostMapping(value = "/confirm")
    public ApiResult confirm(@RequestBody Confirm confirm) {
        if(usersService.selectAndConfirm(confirm))
            return new ApiResult(Code.SUCCESS);
        else
            return new ApiResult(Code.FAILURE);
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @GetMapping(value = "/id/{id}")
    public ApiResult selectId(@PathVariable("id") String id) {
       if(usersService.selectById(id))
           return new ApiResult(Code.SUCCESS);
       else
           return new ApiResult(Code.FAILURE);
    }

    /**
     * 根据mac地址查找
     * @param mac
     * @return
     */
    @GetMapping(value = "/mac/{mac}")
    public ApiResult selectMac(@PathVariable("mac") String mac) {
        if (usersService.selectById(mac))
            return new ApiResult(Code.SUCCESS);
        else
            return new ApiResult(Code.FAILURE);
    }


}
