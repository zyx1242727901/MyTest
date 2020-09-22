package com.example.demo.zookeeper;

import com.myzk.starter.myzkclient.template.MyZkTemplate;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * zhangyuxiao
 * 2020/9/22 15:10
 */
@RestController
@RequestMapping("/myZK")
public class MyZKTemplateController {
    @Autowired
    private MyZkTemplate myZkTemplate;

    @RequestMapping("/createPersist")
    public String createPersist(String path){
        myZkTemplate.createPersistent(path);
        return "success";
    }

    @RequestMapping("/getChildren")
    public String getChildren(String path){
        List<String> children = myZkTemplate.getChildren(path);
        return JSONArray.fromObject(children).toString();
    }
}
