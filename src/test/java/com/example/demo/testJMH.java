package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openjdk.jmh.annotations.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class testJMH {

//    @Benchmark //给jmh扫描
//    @Warmup(iterations = 1,time = 3) //预热多少次，预热多长时间
//    @Fork(5) //开多少现场执行
//    @BenchmarkMode(Mode.Throughput) //吞吐量模式
//    @Measurement(iterations = 1,time = 3) //测试跑多少倍，调用多少次
    public void testForEach() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        final List<Integer> res = new ArrayList<Integer>(10000000);


        list.forEach(v->{
            res.add(v);

        });
    }

    @Benchmark //给jmh扫描
    @Warmup(iterations = 1,time = 3) //预热多少次，预热多长时间
    @Fork(5) //开多少现场执行
    @BenchmarkMode(Mode.Throughput) //吞吐量模式
    @Measurement(iterations = 1,time = 3) //测试跑多少倍，调用多少次
    public void testParallel() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        final List<Integer> res = new ArrayList<Integer>(10000000);

        list.parallelStream().forEach(v->{
            res.add(v);
        });
    }

}
