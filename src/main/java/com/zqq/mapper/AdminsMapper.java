package com.zqq.mapper;

import com.zqq.entity.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhuqingquan on 2017/4/10.
 */
@Mapper
@Repository
public interface AdminsMapper {

    @Insert("insert into admin(id, password) values(#{id}, #{password})")
    int insertAdmin(Admin admin);

    @Select("select * from admin where id=#{id} AND password=#{password}")
    List<Admin> selectAdminByAdmin(Admin admin);

    @Select("select * from admin")
    List<Admin> selectAll();

    @Update("update admin set password = #{password} where id=#{id}")
    int updateAdmin(Admin admin);

    @Select("select * from admin where id=#{id}")
    List<Admin> selectAdminById(@Param("id") String id);

    @Delete("delete from admin where id=#{id}")
    int deleteAdmin(@Param("id") String id);
}
