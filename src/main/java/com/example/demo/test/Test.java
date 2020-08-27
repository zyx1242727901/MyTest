package com.example.demo.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void testLamda(){
        System.out.println("test");
    }

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

//        Test:testLamda();
        Set<Integer> set = new TreeSet();
        int a[][] = {
                {0, 4, 1, 9, 0},
                {4, 0, 7, 2, 0},
                {1, 7, 0, 6, 5},
                {9, 1, 6, 8, 3},
                {0, 0, 1, 3, 0}
        };
        ArrayList<Integer> list = null;
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < a.length; i++) {
            list = new ArrayList<Integer>();
            for (int j = 0; j < a[i].length; j++) {
                list.add(a[i][j]);
            }
            list2.add(list);
        }
         /*   Iterator it = list2.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }*/
        list2.stream().forEach(temp->{
            temp.stream().forEach(integer -> {
                set.add(integer);
            });
        });

        set.stream().forEach(integer ->{
            System.out.println(integer);
        });
//        List<Integer> lst = new ArrayList<Integer>(set);
//        for(int i = 0; i < lst.size(); i++) {
//            for(int j = 1; j < lst.size(); j++){
//                if (lst.get(j) - lst.get(i) == 1) {
//                    System.out.println("连续");
//                }
//            }
//        }

        Iterator<Integer> iterator = set.iterator();
        int low = -1;
        int heigh = 0;
        while (iterator.hasNext()) {
            heigh = iterator.next();
            if (low == -1) {
                low = heigh;
                continue;
            }
            if (heigh - 1 != low) {
                System.out.println("不连续");
                return;
            }
            low = heigh;
        }


    }
}
