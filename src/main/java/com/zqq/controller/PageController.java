package com.zqq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@Controller
public class PageController {

    /**
     * 系统登录
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    /**
     * 管理界面
     * @return
     */
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/addadmin")
    public String addAdmin() {
        return "addadmin";
    }

    @RequestMapping("/content_add")
    public String addContent() {
        return "content_add";
    }

    @RequestMapping("/content_update")
    public String updateAdmin() {
        return "content_update";
    }
}
