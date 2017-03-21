package com.zqq.mapper;

import com.zqq.entity.Confirm;
import com.zqq.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@Mapper
public interface UsersMapper{
    /**
     * 添加用户
     * @param users
     * @return
     */
    @Insert("Insert Into users(mac, id, name, password, age, gendar, intr) values(#{mac}," +
            "#{id}, #{name}, #{password}, #{age}, #{gendar}, #{intr})")
    int insertUsers(Users users);

    /**
     * 验证用户
     * @param conFirm
     * @return
     */
    @Select("select * from users WHERE id=#{id} and password=#{password}")
    List<Users> selectAndConfirm(Confirm conFirm);

    /**
     * 根据mac地址
     * @param mac
     * @return
     */
    @Select("select * from users WHERE mac=#{mac}")
    List<Users> selectByMac(@Param("mac") String mac);

    /**
     * 根据id
     * @param id
     * @return
     */
    @Select("select * from users WHERE id=#{id}")
    List<Users> selectById(@Param("id") String id);
}
