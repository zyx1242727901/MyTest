package com.example.demo.test;

public class Test {
    public static void testLamda(){
        System.out.println("test");
    }

    public static void main(String[] args) throws Exception {
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
//
//
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        FileUtil instance = new FileUtil();
//        System.out.println(ClassLayout.parseInstance(instance).toPrintable());
//        System.out.println("===================");
//
//        synchronized (instance) {
//            System.out.println(ClassLayout.parseInstance(instance).toPrintable());
//        }
//
//        Test:testLamda();


//        FutureTask task = new FutureTask(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                TimeUnit.SECONDS.sleep(60);
//                return "success";
//            }
//        });

//        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 10,
//                0L, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<>(1));
////        executorService.execute(task);
//
//        executorService.execute(new Thread() {
//            @Override
//            public void run()  {
//                try {
//                    TimeUnit.SECONDS.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                int i = 1 / 0;
//
////                return "success";
//            }
//        });
//        executorService.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                TimeUnit.SECONDS.sleep(10);
////                int i = 1/0;
//                return "success";
//            }
//        });
//        executorService.submit(new FutureTask(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                TimeUnit.SECONDS.sleep(10);
////                int i = 1/0;
//
//                return "success";
//            }
//        }));
//        System.out.println(submit.get());
//        new Thread(task).start();
//        System.out.println(task.get());


//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            System.out.println("schedule");
//        }, 0, 10, TimeUnit.SECONDS);
//
//
//        System.out.println("end----------");

//        int[] arr = new int[2];
//        System.out.println(arr[1]);

//        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
//        queue.offer("1");
//        queue.offer("2");
//        System.out.println(queue.poll());
    }
}
