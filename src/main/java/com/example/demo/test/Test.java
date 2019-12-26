package com.example.demo.test;

import com.example.demo.bean.Calculate;
import com.example.demo.config.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        Calculate calculate = (Calculate)ctx.getBean("calculate");
        System.out.println(calculate.add(1));
    }
}
