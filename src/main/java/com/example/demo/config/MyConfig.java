package com.example.demo.config;

import com.example.demo.aspect.TestAspect;
import com.example.demo.bean.Calculate;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.**.*")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyConfig {

//    @Bean
//    public Calculate calculate(){
//        return new Calculate();
//    }
}
