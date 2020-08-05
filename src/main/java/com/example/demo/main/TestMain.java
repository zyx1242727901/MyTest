package com.example.demo.main;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

@Slf4j
public class TestMain {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ThreadLocal threadLocal1 = new ThreadLocal();


//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 10; i++) {
//            executorService.submit(()->{
//                threadLocal1.set("123");
//                System.out.println(threadLocal1.get());
//            System.out.println(threadLocal2.get());
//            System.out.println(threadLocal3.get());
//                Thread thread = Thread.currentThread();
//                System.out.println(thread.getName());
//            });
//
//        }


        //===================== executorService.submit ===================
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        Future<Object> future = executorService.submit(() -> {
//            int i = 1 / 0;
//            return i;
//        });
//        if (future.get() instanceof Exception) {
//            System.out.println(future.get());
//        }

        //===================== CompletionService ===================
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<String>(service);
//
//        for(int i=0; i<50; i++) {
//            final int j = i;
//            completionService.submit(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    if (j == 10) {
//                        int z = j/0;
//                    }
//                    Thread.sleep(RandomUtils.nextInt(5000));
//                    return Thread.currentThread().getName();
//                }
//            });
//        }
//
//        int completionTask = 0;
//        while(completionTask < 50) {
//            //如果完成队列中没有数据, 则阻塞; 否则返回队列中的数据
//            Future<String> resultHolder = completionService.take();
//            System.out.println("result: " + resultHolder.get());
//            completionTask++;
//        }

//        List<String> list = new ArrayList<>(2); list.add("guan");
//        list.add("bao");
//        String[] array = list.toArray(new String[0]);



//        土豆用的
        ArrayList<Integer> list = new ArrayList<Integer>();

        int [] b = {0};
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        list.add(2);
        list.add(1);
//        for(int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i)+"\t");
//        }
        System.out.println();
        List<Integer>[] array = new ArrayList[list.size()];
        List<Integer> parseList = new ArrayList<>();


        Stream.iterate(0, i -> i + 1).limit(list.size()).forEach(i -> {
            Integer temp = list.get(i);
            if (!parseList.contains(temp)) {
                parseList.add(temp);
            }
            int index = parseList.indexOf(temp);
            if (array[index] == null) {
                array[index] = new ArrayList<>();
            }
            array[index].add(i);
        });

        System.out.println();
//        parseList.stream().forEach(integer -> {
//            System.out.print(integer+"\t");
//        });
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].size() > 0) {
                array[i].stream().forEach(integer -> {
                    System.out.println(integer+"\t");
                });
                System.out.println();
            }
        }
    }
}
