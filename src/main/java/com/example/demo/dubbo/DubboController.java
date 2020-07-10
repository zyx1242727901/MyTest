package com.example.demo.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dubbo")
public class DubboController {
    @Reference
    private ProviderService providerService;

    @RequestMapping("/name")
    public String getName(){
        return providerService.getName("凤年");
    }
}
