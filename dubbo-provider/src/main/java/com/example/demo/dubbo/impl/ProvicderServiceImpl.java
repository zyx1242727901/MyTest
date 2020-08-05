package com.example.demo.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.dubbo.ProviderService;

import java.util.concurrent.TimeUnit;

@Service(loadbalance = "random",async = true,timeout = 50000)
public class ProvicderServiceImpl implements ProviderService {
    @Override
    public String getName(String name) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "徐"+name;
    }
}
