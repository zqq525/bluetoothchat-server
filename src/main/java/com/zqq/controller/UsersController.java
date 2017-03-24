package com.zqq.controller;

import com.zqq.entity.Confirm;
import com.zqq.entity.Users;
import com.zqq.entity.reponse.ApiResult;
import com.zqq.enums.Code;
import com.zqq.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ApiResult confirm(@ModelAttribute Confirm confirm) {
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
        Users users = usersService.selectById(id);
       if(users != null)
           return new ApiResult(Code.SUCCESS, users);
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
        Users users = usersService.selectByMac(mac);
        if(users != null)
            return new ApiResult(Code.SUCCESS, users);
        else
            return new ApiResult(Code.FAILURE);
    }

    /**
     * 搜索所有用户
     * @return
     */
    @GetMapping(value = "/")
    public List<Users> selectAll() {
        List<Users> list = usersService.selectAll();
        return list;
    }



}
