package com.zqq.controller;

import com.zqq.entity.reponse.ApiResult;
import com.zqq.enums.Code;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@Controller
public class PageController {

    /**
     * 显示主页
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/content")
    public String content() {
        return "content";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
