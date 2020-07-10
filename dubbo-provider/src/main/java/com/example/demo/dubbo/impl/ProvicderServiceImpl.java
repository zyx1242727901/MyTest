package com.example.demo.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.dubbo.ProviderService;

@Service(loadbalance = "random")
public class ProvicderServiceImpl implements ProviderService {
    @Override
    public String getName(String name) {
        return "徐"+name;
    }
}
