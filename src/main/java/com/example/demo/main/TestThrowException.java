package com.example.demo.main;

public class TestThrowException {
    public void ss() {
        System.out.println("1111");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException("hhhh");
        }
        System.out.println("2222");

    }

    public static void main(String[] args) {
        new TestThrowException().ss();

    }
}
