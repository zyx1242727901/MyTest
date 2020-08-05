package com.example.demo.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
//        config.useClusterServers().addNodeAddress("redis://39.105.95.181:6793",
//                "redis://39.105.95.181:6794","redis://39.105.95.181:6795"
//                ,"redis://39.105.95.181:6796","redis://39.105.95.181:6797"
//                ,"redis://39.105.95.181:6798")
//                .setPassword("yuxiao0122");
        config.useSingleServer().setAddress("redis://39.105.95.181:6793")
                .setPassword("yuxiao0122").setConnectionPoolSize(5).setConnectionMinimumIdleSize(1);
        return Redisson.create(config);
    }
}
