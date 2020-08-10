package com.example.demo.mybatis.mapper2;

import com.example.demo.mybatis.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface RoleMapper {
    @Insert("INSERT INTO test_role(name) VALUES(#{name})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public Long save(Role role);
}
