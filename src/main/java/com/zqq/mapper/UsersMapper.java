package com.zqq.mapper;

import com.zqq.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@Mapper
public interface UsersMapper{
    @Insert("Insert Into users(mac, id, name, password, age, gendar, intr) values(#{mac}," +
            "#{id}, #{name}, #{password}, #{age}, #{gendar}, #{intr})")
    int insertUsers(Users users);
}
