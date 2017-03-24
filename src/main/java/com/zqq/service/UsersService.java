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

    /**
     * 注册
     * @param users
     * @return
     */
    public boolean addUsers(Users users) {
        int cout = usersMapper.insertUsers(users);
        if(cout>0){
            return true;
        }
        return false;
    }

    /**
     * 验证
     * @param confirm
     * @return
     */
    public boolean selectAndConfirm(Confirm confirm){
        List<Users> list = null;
        list = usersMapper.selectAndConfirm(confirm);
        if(list.size()>0)
            return true;
        else
            return false;
    }

    /**
     * 根据MAC地址
     * @param mac
     * @return
     */
    public Users selectByMac(String mac) {
        List<Users> list = null;
        list = usersMapper.selectByMac(mac);
        if(list.size()>0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据ID
     * @param id
     * @return
     */
    public  Users selectById(String id) {
        List<Users> list = null;
        list = usersMapper.selectById(id);
        if(list.size()>0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 获取所有用户
     * @return
     */
    public List<Users> selectAll() {
        List<Users> list = null;
        list = usersMapper.selectAll();
        if(list.size()>0) {
            return list;
        } else {
            return null;
        }
    }
}
