package com.example.demo.config;

import com.example.demo.bean.Calculate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan("com.example.*")
public class MyConfig {

    @Bean
    public Calculate calculate(){
        return new Calculate();
    }
}
