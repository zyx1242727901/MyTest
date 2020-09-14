package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/9 16:18
 */
/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class MyPow {
//     x^n=x^(n/2) * x^(n/2) = (x^2)^(n/2)
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        //n小于0，求x倒数的-n次方
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        //其实就是每次都n/2,求当前值的平方，当n是奇数时，需要多乘一下x
        //n==4 时 x^4 = x^2 * x^2      n==5 时  x^5 = (x^2 * x^2) * x
        while(b > 0) {
            if ((b & 1) == 1) {
                //因为b/2 后  奇数会少一位，所以先给结果乘一下当前值
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, -2));
        System.out.println(Math.pow(0.5, 2));
        System.out.println(1 >> 1);
    }
}
