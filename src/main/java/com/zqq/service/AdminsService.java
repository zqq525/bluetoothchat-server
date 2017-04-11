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
     * 添加管理员
     * @param admin
     * @return
     */
    public boolean addAdmin(Admin admin) {
        int result = adminsMapper.insertAdmin(admin);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

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

    /**
     * 获取所有用户
     * @return
     */
    public List<Admin> selectAll() {
        List<Admin> list = null;
        list = adminsMapper.selectAll();
        if(list.size()>0) {
            return list;
        } else {
            return null;
        }
    }

    /**
     * 更新管理员信息
     * @param admin
     * @return
     */
    public boolean updateAdmin(Admin admin) {
        int result = adminsMapper.updateAdmin(admin);
        if (result > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public boolean selectAdminById(String id) {
        List<Admin> list = null;
        list = adminsMapper.selectAdminById(id);
        if (list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAdminById(String id) {
        int result = adminsMapper.deleteAdmin(id);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
}
