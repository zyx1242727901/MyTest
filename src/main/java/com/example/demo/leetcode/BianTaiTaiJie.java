package com.example.demo.leetcode;

import java.util.Date;

/**
 * zhangyuxiao
 * 2020/9/9 14:07
 */
public class BianTaiTaiJie {

    public int taijie(int n){
        if (n <= 1) {
            return n;
        }
        int i = 1 << (n - 1);
        return i;
    }

    public int taijie1(int n){
        if (n <= 1) {
            return n;
        }
        Date begin = new Date();
        Double i = Math.pow(2, n - 1);
        System.out.println(System.currentTimeMillis()-begin.getTime());
        return i.intValue();
    }

    public static void main(String[] args) {
        int taijie = new BianTaiTaiJie().taijie(4);
        int taijie2 = new BianTaiTaiJie().taijie1(4);
        System.out.println("========="+taijie);
        System.out.println("---------"+taijie2);
        System.out.println(Math.pow(2,3));
        System.out.println(1 <<4 );
    }
}
