package com.example.demo.main;

/**
 *
 */
public class TestVolatile
        implements Runnable
{
    private volatile  static Integer num = 0;

    //方案一=====================================
    @Override
    public void run() {
        for (int j=0;j<1000;j++){
            //TODO 多线程下this的值每个线程都不一样
            synchronized (this) {
//                            System.out.println(this.equals(tmp));
                num++;
            }
        }
    }

    public void incr(){
//        TestVolatile tmp = this;
        for (int i=0;i<10;i++ ) {
            new Thread(this).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);

    }


    public static void main(String[] args) {
        TestVolatile t = new TestVolatile();
        t.incr();
//
//        Integer s = 1;
//        s = 2;
//        System.out.println(s);
    }



    //==================方案二=======================
//    public void incr(){
//        for (int j=0;j<1000;j++){
//            //TODO 多线程下this的值每个线程都不一样
//            synchronized (this) {
////                            System.out.println(this.equals(tmp));
//                num++;
//            }
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        TestVolatile t = new TestVolatile();
//        for(int i=0;i<10;i++) {
//            Thread thread = new Thread(t);
//            thread.start();
//        }
////        t.incr();
////
////        Integer s = 1;
////        s = 2;
////        System.out.println(s);
//    }
//
//    @Override
//    public void run() {
//        this.incr();
//    }
}
