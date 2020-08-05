package com.example.demo.redis;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {
    //    @Autowired
//    private JedisCluster jedisCluster;
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private RedissonClient redissonClient;

    private Integer index = 0;

    private Jedis jedis = null;
    private RBloomFilter bloomFilter = null;
    @PostConstruct
    public void init(){
        jedis = jedisPool.getResource();
        bloomFilter = redissonClient.getBloomFilter("sample");
    }


    @RequestMapping("pubMessage")
    public String pubMessage(String message){
        Long xx = jedis.publish("xx", message);
        System.out.println("===" + xx);

        return xx.toString();
    }

    @RequestMapping("subMessage")
    public String subMessage(String message){
        Executors.newFixedThreadPool(1).execute(()->{
            JedisPubSub jedisPubSub = new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    System.out.println("received::"+message);
                    super.onMessage(channel, message);
                }
            };
            jedis.subscribe(jedisPubSub, "xx");
        });


        return "success";
    }

    @RequestMapping("set")
    public String set(String message){
        String setRes = jedis.set("set", message);
        System.out.println("=setRes= " + setRes);
        System.out.println("=getRes= " + jedis.get("set"));

        return "success";
    }

    @RequestMapping("zset")
    public String zset(){
        jedis.del("set");
        Long zset = jedis.zadd("set", ++index, "member_" + index);
        jedis.zadd("set", ++index, "member_" + index);
        jedis.zadd("set", ++index, "member_" + index);
        jedis.zadd("set", -2, "m_test");
        System.out.println("=setZset= " + zset);
//        String zsetStr = jedis.get("set");
//        System.out.println("=getZset= " + zsetStr);
        Set<String> zset1 = jedis.zrange("set", 0, -1);
        zset1.stream().forEach(s->{
            System.out.println(s);
        });
        jedis.zscore("set", "m_test");

        System.out.println(jedis.zrank("set", "m_test"));
        System.out.println(jedis.zrank("set", "member_1"));

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
//
//    @PostConstruct
//    private void init() {
//        this.subMessage(null);
//    }

    @RequestMapping("redisssionBloom")
    public String redisssionBloom(){
        RBloomFilter bloomFilter = redissonClient.getBloomFilter("sample");

        bloomFilter.tryInit(200, 0.03);
        bloomFilter.add("SKT T1");
        bloomFilter.add("RNG");
        bloomFilter.add("ROX TIGER");

        System.out.println(bloomFilter.contains("EDG"));
        System.out.println(bloomFilter.contains("RNG"));

        return "success";
    }


}
