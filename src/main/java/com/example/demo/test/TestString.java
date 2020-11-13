package com.example.demo.test;

import java.util.HashMap;

/**
 * zhangyuxiao
 * 2020/10/20 19:32
 */
public class TestString {
    public static void main(String[] args) {
//        String a = "abc";
//        String b = new String("abc");
//        String c = new String("dce");
//        System.out.println(b.intern() == "abc");
//        System.out.println(c.intern() == "dce");

//        0: ldc           #2                  // String abc
//        2: astore_1
//        3: new           #3                  // class java/lang/String
//        6: dup
//        7: ldc           #2                  // String abc
//        9: invokespecial #4                  // Method java/lang/String."<init>":(Ljava/lang/String;)V
//        12: astore_2
//        13: new           #3                  // class java/lang/String
//        16: dup
//        17: ldc           #5                  // String dce
//        19: invokespecial #4                  // Method java/lang/String."<init>":(Ljava/lang/String;)V
//        22: astore_3
//        23: return
        HashMap hashMap = new HashMap();
        hashMap.put("11", 11);
    }
}
