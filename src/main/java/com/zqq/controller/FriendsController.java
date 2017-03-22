package com.zqq.controller;

import com.zqq.entity.reponse.ApiResult;
import com.zqq.enums.Code;
import com.zqq.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@RestController
@RequestMapping("/friends")
public class FriendsController {
    @Autowired
    private FriendsService friendsService;

    /**
     * 添加朋友
     * @param mid
     * @param fid
     * @return
     */
    @GetMapping("/")
    public ApiResult addFriends(@PathVariable String mid, @PathVariable String fid) {
        if (friendsService.addFriends(mid, fid))
            return new ApiResult(Code.SUCCESS);
        else
            return new ApiResult(Code.FAILURE);
    }

    /**
     * 根据自己的mid返回所有好友的fid
     * @param mid
     * @return
     */
    @GetMapping("/{mid}")
    public List<String> searchFriends(@PathVariable String mid) {
        List<String> list = new ArrayList<>();
        list.add("");
        return Optional.of(friendsService.searchFriends(mid)).orElse(list);
    }

    /**
     * 删除好友关系
     * @param mid
     * @param fid
     * @return
     */
    @DeleteMapping("/")
    public ApiResult deleteFriends(@PathVariable String mid, @PathVariable String fid) {
        if (friendsService.deleteFriends(mid, fid))
            return new ApiResult(Code.SUCCESS);
        else
            return new ApiResult(Code.FAILURE);
    }
}
