package com.example.demo.rocketmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * zhangyuxiao
 * 2020/9/21 18:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestBean implements Serializable {
    private String name;
    private int age;
}
