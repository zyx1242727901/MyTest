package com.example.demo.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {
    //    @Autowired
//    private JedisCluster jedisCluster;
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("pubMessage")
    public String pubMessage(String message){
        Jedis jedis = jedisPool.getResource();
        Long xx = jedis.publish("xx", message);
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
        Jedis jedis = jedisPool.getResource();
        jedis.subscribe(jedisPubSub, "xx");

        return "success";
    }

    //==========redission==============
    @RequestMapping("redisssionLock")
    public String redisssionLock(){

        RLock xxA = redissonClient.getLock("age");
        try {
//            xxA.tryLock(5, TimeUnit.SECONDS);
            System.out.println("try lock 1   "+Instant.now().getEpochSecond());

            xxA.lock(60,TimeUnit.SECONDS);

            System.out.println("lock success1   "+Instant.now().getEpochSecond());
            Thread.sleep(1000*30);
            System.out.println("lock relase 1   "+ Instant.now().getEpochSecond());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            xxA.unlock();
        }


        return "success";
    }

    @RequestMapping("redisssionLock1")
    public String redisssionLock1(){

        RLock xxA = redissonClient.getLock("age");
        try {
            System.out.println("try lock 2   "+Instant.now().getEpochSecond());

//            xxA.tryLock(5, TimeUnit.SECONDS);
            xxA.lock(60,TimeUnit.SECONDS);
            System.out.println("lock success2   "+ Instant.now().getEpochSecond());

            Thread.sleep(1000*30);
            System.out.println("lock relase 2   "+ Instant.now().getEpochSecond());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            xxA.unlock();
        }


        return "success";
    }


}
