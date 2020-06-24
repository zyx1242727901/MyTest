package com.example.demo.test;

import com.example.demo.bean.Calculate;
import com.example.demo.config.MyConfig;
import com.example.demo.weixin.FileUtil;
import org.apache.commons.beanutils.BeanMap;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
////        Calculate calculate = (Calculate)ctx.getBean("calculate");
//        Calculate calculate = (Calculate)ctx.getBean(Calculate.class);
//        System.out.println(calculate);
//        System.out.println(calculate.doAdd(1));
//        System.out.println(calculate.add(1));

//        ReentrantLock reentrantLock = new ReentrantLock();
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                reentrantLock.lock();
//            }
//        });
//        t1.start();
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                reentrantLock.lock();
//            }
//        });
//        t2.start();
//        try {
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        reentrantLock1.lock();
//        reentrantLock.unlock();


//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        FileUtil instance = new FileUtil();
//        System.out.println(ClassLayout.parseInstance(instance).toPrintable());
//        System.out.println("===================");
//
//        synchronized (instance) {
//            System.out.println(ClassLayout.parseInstance(instance).toPrintable());
//        }

    }
}
