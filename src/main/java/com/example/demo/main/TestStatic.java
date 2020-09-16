package com.example.demo.main;

/**
 * zhangyuxiao
 * 2020/9/16 15:43
 */
public class TestStatic {
    public static void main(String[] args) {
        System.out.println(T.count);
        System.out.println(new T().count);
    }
    static class T{
        public static int count = 2;
        static {
            count++;
        }
        public T(){
            count++;
        }
    }
}
