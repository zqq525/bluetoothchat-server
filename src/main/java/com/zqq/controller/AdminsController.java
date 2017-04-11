package com.zqq.controller;

import com.github.pagehelper.PageHelper;
import com.zqq.entity.Admin;
import com.zqq.entity.Users;
import com.zqq.entity.reponse.ApiResult;
import com.zqq.enums.Code;
import com.zqq.service.AdminsService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhuqingquan on 2017/4/10.
 */
@RestController
@RequestMapping("/admin")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;

    @PostMapping("/add")
    public ApiResult addAdmin(@ModelAttribute Admin admin) {
        if(adminsService.addAdmin(admin)) {
            return new ApiResult(Code.SUCCESS);
        }else {
            return new ApiResult(Code.FAILURE);
        }
    }

    /**
     * 认证
     * @param admin
     * @return
     */
    @PostMapping("/confirm")
    public ApiResult confirm(@ModelAttribute Admin admin) {
        if(adminsService.confirm(admin))
            return new ApiResult(Code.SUCCESS);
        else
            return new ApiResult(Code.FAILURE);
    }

    /**
     * 搜索所有用户
     * @return
     */
    @GetMapping("/{page}")
    public List<Admin> selectAll(@PathVariable("page") int page) {
        if(page > 0) {
            PageHelper.startPage(page, 15);
        }
        List<Admin> list = adminsService.selectAll();
        return list;
    }

    @PutMapping("/update")
    public ApiResult updateAdmin(@ModelAttribute Admin admin) {
        if(adminsService.updateAdmin(admin)) {
            return new ApiResult(Code.SUCCESS);
        }else {
            return new ApiResult(Code.FAILURE);
        }
    }

    @GetMapping("/id/{id}")
    public ApiResult selectById(@PathVariable("id") String id) {
        if (adminsService.selectAdminById(id))
            return new ApiResult(Code.SUCCESS);
        else
            return new ApiResult(Code.FAILURE);
    }

    @GetMapping("/delete/{id}")
    public ApiResult deleteById(@PathVariable("id") String id) {
        if (adminsService.deleteAdminById(id))
            return new ApiResult(Code.SUCCESS);
        else
            return new ApiResult(Code.FAILURE);
    }

}
