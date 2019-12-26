package com.example.demo.singlton;

//懒汉式---1
//public class HungrySinglton {
//    private static HungrySinglton hungrySinglton = new HungrySinglton();
//
//    private static HungrySinglton getInstance() {
//        return hungrySinglton;
//    }
//}


//懒汉式---2
public class HungrySinglton {
    private static HungrySinglton hungrySinglton ;

    static {
        hungrySinglton = new HungrySinglton();
    }

    public static HungrySinglton getInstance() {
        return hungrySinglton;
    }
}
