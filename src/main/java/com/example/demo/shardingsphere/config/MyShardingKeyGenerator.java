package com.example.demo.shardingsphere.config;

import lombok.Data;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

@Data
@Component
public class MyShardingKeyGenerator implements ShardingKeyGenerator {
    @Autowired
    private JedisPool jedisPool;

    private static Jedis jedis = null;

    @PostConstruct
    private void init() {
        jedis = jedisPool.getResource();
    }

    @Override
    public Comparable<?> generateKey() {
        int index = ThreadLocalRandom.current().nextInt(2);
        for (int i=0;i<index;i++) {
            jedis.incr("shardingKey");
        }
        return jedis.incr("shardingKey");
    }

    @Override
    public String getType() {
        return "REDIS";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
