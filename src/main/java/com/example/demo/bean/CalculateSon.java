package com.example.demo.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary 多个同类型的类，优先用有该注解的类注入
//@Component
public class CalculateSon extends Calculate {
    @Override
    public int doAdd(int a){
        System.out.println("2222"+this);
        return this.add(a);
    }
}
