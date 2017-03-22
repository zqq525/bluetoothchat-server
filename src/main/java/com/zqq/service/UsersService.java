package com.zqq.service;

import com.zqq.entity.Confirm;
import com.zqq.entity.Users;
import com.zqq.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean selectAndConfirm(Confirm confirm){
        List<Users> list = null;
        list = usersMapper.selectAndConfirm(confirm);
        if(list.size()>0)
            return true;
        else
            return false;
    }

    public boolean selectByMac(String mac) {
        List<Users> list = null;
        list = usersMapper.selectByMac(mac);
        if(list.size()>0)
            return true;
        else
            return false;
    }

    public boolean selectById(String id) {
        List<Users> list = null;
        list = usersMapper.selectById(id);
        if(list.size()>0)
            return true;
        else
            return false;
    }
}
