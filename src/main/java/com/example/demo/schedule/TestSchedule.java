package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TestSchedule {

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void test1(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1 start"+System.nanoTime());
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void test2(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t2 start"+System.nanoTime());
    }
}
