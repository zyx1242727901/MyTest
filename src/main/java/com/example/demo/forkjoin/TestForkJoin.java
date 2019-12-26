package com.example.demo.forkjoin;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TestForkJoin extends RecursiveTask {
    private int start;
    private int end;

    private static Integer THREAD_HOLD = 5000;

    public TestForkJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Object compute() {
        int result = 0;
        if(start == end){
            return end;
        }
        if (this.end - this.start >= THREAD_HOLD) {
            int mid = (end+start)/2;
            TestForkJoin f1 = new TestForkJoin(start, mid);
            TestForkJoin f2 = new TestForkJoin(mid + 1, end);

            invokeAll(f1, f2);
//            f1.fork();
//            f2.fork();

            int result1 = (int) f1.join();
            int result2 = (int) f2.join();
            result = result1 + result2;
        } else {
            for (int i = start; i <= end; i++) {
//                double random = Math.random();
//                System.out.println(i);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                result+=i;
            }
        }

        return result;
    }

    public Integer forEachCompute(){
        int result = 0;
        for (int i = 1; i <= end; i++) {
            result+=i;
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        
        TestForkJoin testForkJoin = new TestForkJoin(1, 1000000000);

        Date start1 = new Date();
        ForkJoinTask<Object> fk = pool.submit(testForkJoin);
        Integer res1 = (Integer) fk.get();
        Date end1 = new Date();
        System.out.println(res1 + "====" + (end1.getTime() - start1.getTime()));

        Date start3 = new Date();
        ForkJoinPool pool1 = new ForkJoinPool();
        Integer res3 = (Integer) pool1.invoke(testForkJoin);
        Date end3 = new Date();
        System.out.println(res3 + "====" + (end3.getTime() - start3.getTime()));

        Date start2 = new Date();
        Integer res2 = (Integer) testForkJoin.forEachCompute();
        Date end2 = new Date();
        System.out.println(res2+"===="+(end2.getTime()-start2.getTime()));

    }
}
