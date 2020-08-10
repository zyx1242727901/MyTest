package com.example.demo.mybatis.service;


import com.example.demo.mybatis.entity.Role;
import com.example.demo.mybatis.entity.User;
import com.example.demo.mybatis.mapper1.UserMapper;
import com.example.demo.mybatis.mapper2.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MybatisServiceImpl implements MybatisService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Transactional
    @Override
    public void testDoubleDataSource(Integer key) {

        userMapper.save(new User(null,"zhangsan",0L));
        if (key != null) {
            int i = 1/0;
        }
        roleMapper.save(new Role(null, "lisi"));
    }
}

