package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/11/3 15:57
 */
public class HammingWeight {
    public int hammingWeight(long n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n = n >>> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(-2 >> 1);
        System.out.println(-2 >>> 1);    }
}
