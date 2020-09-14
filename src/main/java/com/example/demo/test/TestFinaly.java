package com.example.demo.test;

/**
 * zhangyuxiao
 * 2020/9/8 16:17
 */
public class TestFinaly {

    public static int testFinally(){
        int i = 0;

        try {
            i++;
            return i++;
        } catch (Exception e) {
            return -1;
        }finally {
            i++;
        }

    }
    public static void main(String[] args) {
        System.out.println(TestFinaly.testFinally());
    }
}
