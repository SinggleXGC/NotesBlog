package com.xgc.notesblog.mapper;

import com.xgc.notesblog.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select COUNT(uid) from user where username = #{username}")
    int countUserByUsername(String username);

    @Select("select * from user where username = #{username}")
    User selectUserByUserName(String username);

    @Select("select * from user where uid = #{uid}")
    User selectUserByUid(Integer uid);
}
