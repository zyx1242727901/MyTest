package com.example.demo.main;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
@Slf4j
public class TestVolatileA implements Runnable {

    int count = 0;
    CountDownLatch latch = new CountDownLatch(100);

    private int a = 0;
    private int b = 0;
    private volatile boolean flag = false;


    public void writer(){
//        System.out.println("enter AAA");

        a = 1;         //1
        flag = true;   //2
//        writer2();
//        System.out.println("UPDATE");
    }

    public void writer2(){
//        System.out.println("enter BBBBBB");
        b = 2;

//        System.out.println("UPDATE BBBBBB");
    }

    public String reader(){
        while (true) {
//            System.out.println(a+"--"+b);

            if(flag){      //3
                int i =a;
                int j = b;
                while (b == 0) {
                    continue;
                }
//                System.out.println(a);
//                System.out.println(b);
                return i+"=="+j;
//                continue;
            }
        }
    }

    public void add() {
        count++;
        System.out.println("Thread " + Thread.currentThread().getName() + "   count=" + count);
    }

    @Override
    public void run() {
//        this.add();

    }

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        TestVolatileA t = new TestVolatileA();
//
//        for (int i=0;i<100;i++) {
//            t.latch.countDown();
//            new Thread(t).start();
//        }
//        executorService.shutdown();

        TestVolatileA target = new TestVolatileA();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(target.reader());
            }
        }).start();


//        TimeUnit.SECONDS.sleep(1);
        new Thread(new Runnable() {
            @Override
            public void run() {

                target.writer();
            }
        }).start();
//        TimeUnit.SECONDS.sleep(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                target.writer2();
            }
        }).start();


    }


}
