package com.example.demo.deadlock;

import java.util.LinkedList;

/**
 * zhangyuxiao
 * 2020/10/9 15:20
 */
public class DeadLock {
    public static void main(String[] args) {
//        Resource666 res1 = new Resource666();
//        Resource666 res2 = new Resource666();
//        res1.flag = true;
//        res2.flag = false;
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                res1.method();
//            }
//        }, "A").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                res2.method();
//            }
//        },"B").start();

        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.forEach(o -> {
            System.out.println(o);
        });
    }
}

class Resource666 {
    boolean flag = true;
    private static final Object obj1 = new Object();
    private static final Object obj2 = new Object();

    public void method() {
        if (flag) {
            synchronized (obj1) {
                System.out.println(Thread.currentThread().getName() + " " + "获取到锁1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + " " + "获取到锁2");
                }
            }
        } else {
            synchronized (obj2) {
                System.out.println(Thread.currentThread().getName() + " " + "获取到锁2");
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + " " + "获取到锁1");
                }
            }
        }
    }
}


