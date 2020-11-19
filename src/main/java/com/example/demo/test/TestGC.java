package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * zhangyuxiao
 * 2020/11/17 19:23
 */
public class TestGC {
    public static void main(String[] args) {
        int i = 0;
//
        while (i++ <2000 ) {
            TestGC.incr();
        }
    }
    public static void incr(){
        List<Object> list=new ArrayList<>();
        // 不断创建对象，并保证GC Roots到对象之间有可达路径，避免垃圾回收清除创建的对象
        int i = 0;
//
        while (i++ <200000 ) {
            list.add(new TestOOM.OOMObject());
        }
    }
}
