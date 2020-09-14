package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/8 16:26
 */

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 */
public class TiaoTaiJie {
    //1
//    int sum = 0;
//    public int numWays(int n) {
//        sum = n;
//        return digui(0, 0);
//    }
//
//    public int digui(int index,int step){
//        if (index +step > sum) {
//            return 0;
//        }
//        if (index +step == sum) {
//            return 1;
//        }
//        index = index + step;
//        return digui(index, 1) % 1000000007 + digui(index, 2) % 1000000007;
//    }

    //2
    public int numWays1(int n) {
        int f1 = 1;
        int f2 = 2;

        int curr = 0;

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            n -= 2;
            while (n > 0) {
                curr = (f1 + f2) % 1000000007;
                f1 = f2;
                f2 = curr;
                n--;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new TiaoTaiJie().numWays1(48));
    }
}
