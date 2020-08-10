package com.example.demo.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class User {
    private Long id;
    private String nickName;
    private Long userRole;
}
