package com.example.demo.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zk")
public class ZKController {
    @Autowired
    private ZkClient zkClient;

    @RequestMapping("test")
    public String testZK(){
        List<String> children = zkClient.getChildren("/");
        children.stream().forEach(s -> {
            System.out.println(s);
        });
        return "success";
    }
}
