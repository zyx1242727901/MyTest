package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.util.concurrent.Executors;

@RestController
public class RedisController {
    //    @Autowired
//    private JedisCluster jedisCluster;
    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("pubMessage")
    public String pubMessage(String message){
        Jedis jedisCluster = jedisPool.getResource();
        Long xx = jedisCluster.publish("xx", message);
        System.out.println("===" + xx);

        return xx.toString();
    }

    @RequestMapping("subMessage")
    public String subMessage(String message){
        JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("received::"+message);
                super.onMessage(channel, message);
            }
        };
        Jedis jedisCluster = jedisPool.getResource();
        jedisCluster.subscribe(jedisPubSub, "xx");

        return "success";
    }
}
