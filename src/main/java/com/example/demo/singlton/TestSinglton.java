package com.example.demo.singlton;

import java.lang.reflect.Constructor;

public class TestSinglton {
    public static void main(String[] args) {
        EnumSinglton enumSinglton = EnumSinglton.INSTANCE;
        enumSinglton.setData(new HungrySinglton());

        System.out.println(EnumSinglton.INSTANCE.getData());
    }
}
