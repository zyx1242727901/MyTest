package com.example.demo.main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestVolatileA implements Runnable {

    int count = 0;
    CountDownLatch latch = new CountDownLatch(100);

    public void add() {
        count++;
        System.out.println("Thread " + Thread.currentThread().getName() + "   count=" + count);
    }

    @Override
    public void run() {
        this.add();

    }

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
        TestVolatileA t = new TestVolatileA();

        for (int i=0;i<100;i++) {
            t.latch.countDown();
            new Thread(t).start();
        }
//        executorService.shutdown();
    }


}
