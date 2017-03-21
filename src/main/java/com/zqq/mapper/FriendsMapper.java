package com.zqq.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhuqingquan on 2017/3/21.
 */
@Mapper
public interface FriendsMapper {

    /**
     * 根据用户的id查找自己的好友
     * @param mid
     * @return
     */
    @Results({
            @Result(property = "fid", column = "fid")
    })
    @Select("select friends WHERE mid = #{mid}")
    List<String> findFriendsBymid(@Param("mid") String mid);

    /**
     * mid和fid共同插入数据表friends中
     * @param mid
     * @param fid
     * @return
     */
    @Insert("insert into friends(mid,fid) values(#{mid}, #{fid})")
    int addriendsBymidAndfid(@Param("mid") String mid, @Param("fid") String fid);
}
