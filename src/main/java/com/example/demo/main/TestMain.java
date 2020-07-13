package com.example.demo.main;

import net.sf.json.JSONObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {



    public static void main(String[] args) {
        ThreadLocal threadLocal1 = new ThreadLocal();


//        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
//            executorService.submit(()->{
                threadLocal1.set("123");
                System.out.println(threadLocal1.get());
//            System.out.println(threadLocal2.get());
//            System.out.println(threadLocal3.get());
//                Thread thread = Thread.currentThread();
//                System.out.println(thread.getName());
//            });

        }

    }
}
