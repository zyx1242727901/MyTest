package com.example.demo.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * zhangyuxiao
 * 2020/10/30 13:51
 */
public class TestOOM {
        public static class OOMObject {}
        public static void main(String[] args) {
            new Thread(() -> {
                while(true){
                    System.out.println(new Date().toString() + Thread.currentThread() + "www.xttblog.com");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(() -> {
                List<Object> list=new ArrayList<>();
                // 不断创建对象，并保证GC Roots到对象之间有可达路径，避免垃圾回收清除创建的对象
                while (true) {
                    list.add(new OOMObject());
                    System.out.println(System.currentTimeMillis());
                }
            }).start();
        }


}
