package com.zqq.controller;

import com.zqq.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@RestController
public class FriendsController {
    @Autowired
    private FriendsService friendsService;
}
