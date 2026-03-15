package org.example.bk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.example.trpojo.entity.User;
@Mapper
public interface UserMapper {

    @Select("select *from user where username=#{userName}")
    User findByUsername(String userName);

    @Insert("insert into user(username,password,created_at) values(#{username},#{password},#{createdAt})")
    int insert(User user);

}
