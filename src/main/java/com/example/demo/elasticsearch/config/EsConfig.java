package com.example.demo.elasticsearch.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {
    static {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }
}
