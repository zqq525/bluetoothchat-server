package com.zqq.service;

import com.zqq.entity.Users;
import com.zqq.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public boolean addUsers(Users users) {
        int cout = usersMapper.insertUsers(users);
        if(cout>0){
            return true;
        }
        return false;
    }
}
