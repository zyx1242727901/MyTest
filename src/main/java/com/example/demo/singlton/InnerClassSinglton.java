package com.example.demo.singlton;

public class InnerClassSinglton {

    public static InnerClassSinglton getInstance(){
        return InstanceClass.innerClassSinglton;
    }

    //由于静态内部类只有在getInstance()被调用时才会初始化，所以该方式也是懒汉式
    static class InstanceClass{
        private static InnerClassSinglton innerClassSinglton = new InnerClassSinglton();
    }
}
