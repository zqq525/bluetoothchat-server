package com.zqq.controller;

import com.zqq.entity.Admin;
import com.zqq.entity.reponse.ApiResult;
import com.zqq.enums.Code;
import com.zqq.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuqingquan on 2017/4/10.
 */
@RestController
@RequestMapping("/admin")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;

    @PostMapping("/confirm")
    public ApiResult confirm(@ModelAttribute Admin admin) {
        if(adminsService.confirm(admin))
            return new ApiResult(Code.SUCCESS);
        else
            return new ApiResult(Code.FAILURE);
    }

}
