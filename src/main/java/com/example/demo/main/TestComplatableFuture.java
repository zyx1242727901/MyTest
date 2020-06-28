package com.example.demo.main;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestComplatableFuture {

    public static void main(String[] args) {
        CompletableFuture future1 = CompletableFuture.supplyAsync(() -> returnNum(2));
        CompletableFuture future2 = CompletableFuture.supplyAsync(() -> returnNum(5));
        CompletableFuture future3 = CompletableFuture.supplyAsync(() -> returnNum(1));
        System.out.println("end");

        CompletableFuture.allOf(future1, future2, future3).join();

        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        Executors.newScheduledThreadPool(1);


    }

    public static int returnNum(int num){
        System.out.println("==="+num);

        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return num;
    }
}
