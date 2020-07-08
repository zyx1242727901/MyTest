package com.example.demo.redis;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.*;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisClusterConfig {
//    @Bean
//    public JedisCluster redisCluster(){
//        Set<HostAndPort> hostAndPortSet = new HashSet<>(8);
//        hostAndPortSet.add(new HostAndPort("39.105.95.181", 6793));
//        hostAndPortSet.add(new HostAndPort("39.105.95.181", 6794));
//        hostAndPortSet.add(new HostAndPort("39.105.95.181", 6795));
//        hostAndPortSet.add(new HostAndPort("39.105.95.181", 6796));
//        hostAndPortSet.add(new HostAndPort("39.105.95.181", 6797));
//        hostAndPortSet.add(new HostAndPort("39.105.95.181", 6798));
//
//        JedisCluster cluster = new JedisCluster(hostAndPortSet, 5000,3000,10,"yuxiao0122", new JedisPoolConfig());
//        return cluster;
//    }
    @Bean
    public JedisPool getJedisPool(){
    //    Set<HostAndPort> hostAndPortSet = new HashSet<>(8);
    //    hostAndPortSet.add(new HostAndPort("39.105.95.181", 6793));
    //    hostAndPortSet.add(new HostAndPort("39.105.95.181", 6794));
    //    hostAndPortSet.add(new HostAndPort("39.105.95.181", 6795));
    //    hostAndPortSet.add(new HostAndPort("39.105.95.181", 6796));
    //    hostAndPortSet.add(new HostAndPort("39.105.95.181", 6797));
    //    hostAndPortSet.add(new HostAndPort("39.105.95.181", 6798));
        new JedisPoolConfig();
        JedisPool JedisPool = new JedisPool(new JedisPoolConfig(),"39.105.95.181",6793,5000,"yuxiao0122");
        return JedisPool;
    }
}
