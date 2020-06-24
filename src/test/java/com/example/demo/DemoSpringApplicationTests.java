package com.example.demo;

import com.example.demo.bean.Calculate;
import com.example.demo.config.MyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoSpringApplication.class)
public class DemoSpringApplicationTests {
    @Autowired
    private Calculate calculate;

    @Test
    public void testAspect() {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
//        Calculate calculate = (Calculate)ctx.getBean("calculate");
        System.out.println(AopUtils.isCglibProxy(calculate));
        System.out.println(AopUtils.isJdkDynamicProxy(calculate));
        System.out.println(calculate.add(2));
        System.out.println("================");
        System.out.println(calculate.doAdd(1));
    }



}
