package com.example.demo.threadjoin;

public class TestJoin {

    public void test(){
//        for(int i=0;i<10;i++){
            Thread o1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        for (int j =0;j<100;j++) {
                            System.out.println("Thread 1 start============");
                        }
                        Thread.sleep(2000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 1 end===========");
                }
            });
            Thread o2 = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(4000);
                        for (int j =0;j<100;j++) {
                            System.out.println("Thread 2 start");
                        }
                        Thread.sleep(2000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 2 end");
                }
            });



            try {

                o1.start();
                o2.start();
                System.out.println("start join");


                o1.join();
                System.out.println("start join1++++++");

                o2.join();
                System.out.println("start join2++++++");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        testJoin.test();
    }

}
