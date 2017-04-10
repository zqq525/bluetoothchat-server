package com.zqq.mapper;

import com.zqq.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhuqingquan on 2017/4/10.
 */
@Mapper
@Repository
public interface AdminsMapper {

    @Select("select * from admin where id=#{id} AND password=#{password}")
    List<Admin> selectAdminByAdmin(Admin admin);

}
