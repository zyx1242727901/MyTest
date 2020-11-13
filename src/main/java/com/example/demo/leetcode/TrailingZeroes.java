package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/25 17:40
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        long divisor = 5;
        int res = 0;
        while (divisor <= n) {
            //当前值含有几个5
            res += n / divisor;
            //然后计算含有多少个5的倍数，5的倍数都可以多提供一个5
            divisor *= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TrailingZeroes().trailingZeroes(125));
    }
}
