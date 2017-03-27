package com.zqq.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@Mapper
@Repository
public interface FriendsMapper {

    /**
     * 根据用户的id查找自己的好友
     * @param mid
     * @return
     */
    @Results({
            @Result(property = "fid", column = "fid")
    })
    @Select("select fid from friends WHERE mid = #{mid}")
    List<String> findFriendsBymid(@Param("mid") String mid);

    /**
     * mid和fid共同插入数据表friends中
     * @param mid
     * @param fid
     * @return
     */
    @Insert("insert into friends(mid,fid) values(#{mid}, #{fid})")
    int addriendsBymidAndfid(@Param("mid") String mid, @Param("fid") String fid);

    /**
     * 根据mid和fid删除好友
     * @param mid
     * @param fid
     * @return
     */
    @Delete("delete from friends Where mid=#{mid} and fid=#{fid}")
    int deleteBymidAndfid(@Param("mid") String mid, @Param("fid") String fid);

    /**
     * 搜索已经存在的好友
     * @param mid
     * @param fid
     * @return
     */
    @Select("select fid from friends where mid=#{mid} and fid=#{fid]")
    List<String> findBymidAndfid(@Param("mid") String mid, @Param("fid") String fid);
}
