package com.zqq.service;

import com.zqq.mapper.FriendsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@Service
public class FriendsService {

    @Autowired
    private FriendsMapper friendsMapper;

    public boolean addFriends(String mid, String fid) {
        int result = friendsMapper.addriendsBymidAndfid(mid, fid);
        if (result > 0)
            return true;
        else
            return false;
    }

    public List<String> searchFriends(String mid) {
        List<String> list = null;
        list = friendsMapper.findFriendsBymid(mid);
        return list;
    }

    public boolean deleteFriends(String mid, String fid) {
        int result;
        result = friendsMapper.deleteBymidAndfid(mid, fid);
        if (result > 0)
            return true;
        else
            return false;
    }

    public boolean searchExistFriends(String mid, String fid){
        List<String> list = null;
        list = friendsMapper.findBymidAndfid(mid, fid);
        if(list.size()>0)
            return true;
        else
            return false;
    }
}
