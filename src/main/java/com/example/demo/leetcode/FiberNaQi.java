package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/8 15:44
 */

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 *         F(0) = 0,   F(1) = 1
 *         F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *         斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 *         答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class FiberNaQi {
    public int fib(int n) {
        int f1 = 0, f2 = 1;
        int curr = 0;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            n=n-1; //从第三位开始算
            while (n > 0) {
                curr = (f1 + f2) % 1000000007;
                f1 = f2;
                f2 = curr;
                n--;
            }
        }

        return curr ;
    }

    public static void main(String[] args) {
        System.out.println(new FiberNaQi().fib(48));
    }
}
