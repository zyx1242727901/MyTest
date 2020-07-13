package com.example.demo.thread;

import com.alibaba.dubbo.common.threadpool.support.fixed.FixedThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadName {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), new UserThreadFactory("testMain"));
        for (int i=0;i<10;i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName());

            });
        }
    }
}
