package com.example.demo.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZKConfig {
    @Bean
    public ZkClient getInstans(){
        ZkClient zkClient = new ZkClient("39.105.95.181:2181", 500, 1000 * 60);
        zkClient.setZkSerializer(new MyZkSerializer());
        return zkClient;
    }
}
