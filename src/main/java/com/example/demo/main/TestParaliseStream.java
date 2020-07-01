package com.example.demo.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestParaliseStream {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        final List<Integer> res = new ArrayList<Integer>();

        Date begin = new Date();
        list.parallelStream().forEach(v->{
            res.add(v);
            try {
                TimeUnit.NANOSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(new Date().getTime()-begin.getTime());

         begin = new Date();
        list.forEach(v->{
            res.add(v);
            try {
                TimeUnit.NANOSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(new Date().getTime()-begin.getTime());
    }
}
