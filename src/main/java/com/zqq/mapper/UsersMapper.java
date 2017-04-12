package com.zqq.mapper;

import com.zqq.entity.Confirm;
import com.zqq.entity.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@Mapper
@Repository
public interface UsersMapper{
    /**
     * 添加用户
     * @param users
     * @return
     */
    @Insert("Insert Into users(mac, id, name, password, phone, birthday, age, gendar, intr, time) values(#{mac}," +
            "#{id}, #{name}, #{password}, #{phone}, #{birthday}, #{age}, #{gendar}, #{intr}, #{time})")
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
    @Results({

    })
    List<Users> selectById(@Param("id") String id);

    /**
     * 查找
     * @return
     */
    @Select("select * from users")
    List<Users> selectAll();

    /**
     * 修改用户信息
     * @param mac
     * @param name
     * @param phone
     * @param birthday
     * @param intr
     * @return
     */
    @Update("update users set name=#{name} ,phone=#{phone}, age=#{age}, birthday=#{birthday}, intr=#{intr} where mac = #{mac}")
    int updateUser(@Param("mac") String mac,
                   @Param("name") String name,
                   @Param("phone") String phone,
                   @Param("age") String age,
                   @Param("birthday") String birthday,
                   @Param("intr") String intr);

    @Update("update user set password=#{password} where mac=#{mac}")
    int updatePassword(@Param("mac") String mac, @Param("password") String password);
}
