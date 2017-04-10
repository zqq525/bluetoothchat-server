package com.zqq.service;

import com.zqq.entity.Admin;
import com.zqq.mapper.AdminsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuqingquan on 2017/4/10.
 */
@Service
public class AdminsService {
    @Autowired
    private AdminsMapper adminsMapper;

    /**
     * 验证管理员
     * @param admin
     * @return
     */
    public boolean confirm(Admin admin) {
        List<Admin> list;
        list = adminsMapper.selectAdminByAdmin(admin);
        if (list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
