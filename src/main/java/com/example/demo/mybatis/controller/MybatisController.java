package com.example.demo.mybatis.controller;

import com.example.demo.mybatis.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mybatis")
public class MybatisController {
    @Autowired
    private MybatisService mybatisService;

    @RequestMapping("testDoubleDataSource")
    public String testDoubleDataSource(@RequestParam(required = false) Integer key){
        mybatisService.testDoubleDataSource(key);
        return "success";
    }
}
