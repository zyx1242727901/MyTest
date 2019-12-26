package com.example.demo.bean;

import com.example.demo.annotation.MyAnnotation;
import org.springframework.stereotype.Component;


public class Calculate {

    @MyAnnotation
    public int add(int a){
        return 1+a;
    }
}