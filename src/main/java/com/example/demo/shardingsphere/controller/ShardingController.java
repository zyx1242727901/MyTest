package com.example.demo.shardingsphere.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.mybatis.entity.Order;
import com.example.demo.mybatis.entity.OrderItem;
import com.example.demo.mybatis.mapper1.OrderMapper;
import com.github.pagehelper.PageHelper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShardingController {
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/testSharding")
    public String testSharding(){
        for (long i = 0; i < 20; i++) {
            orderMapper.insert(new Order(null, i+1, i));
            orderMapper.insertOrderItem(i, i % 5);
        }
        return "success";
    }
    @RequestMapping("/createTable")
    public String createTable(){
        orderMapper.createTableOrder();
        orderMapper.createTableItem();
        return "success";
    }

    @RequestMapping("/selectOrderItem")
    public String createTable(Long id, int size) {

        System.out.println();
        //主库强制路由，适用于某些时效性非常强的业务，避免从库还未同步到数据
        //只作用于最近的一条查询语句
        //hintManager实现了AutoCloseable接口，可推荐使用try with resource自动关闭。
        try (HintManager manager = HintManager.getInstance();) {
            manager.setMasterRouteOnly();
            PageHelper.startPage(1, size);
            List<OrderItem> orderItem = orderMapper.selectOrderItem(id);
            return JSON.toJSONString(orderItem);
        }

    }
}
