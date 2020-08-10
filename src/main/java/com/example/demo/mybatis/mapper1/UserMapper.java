package com.example.demo.mybatis.mapper1;

import com.example.demo.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO testUser(nick_name,user_role) VALUES(#{nickName},#{userRole})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public Long save(User user);
}
