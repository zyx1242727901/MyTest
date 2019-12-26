package com.example.demo.singlton;

public class SynchronizeSinglton {
    private static SynchronizeSinglton singlton;

    public static synchronized SynchronizeSinglton getInstance(){
        if(singlton == null){
            singlton = new SynchronizeSinglton();
        }
        return singlton;
    }
}
