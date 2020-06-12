package com.example.demo.leetcode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 *
 * 没做完，太没意思，再就是最大值判断，比较烦
 */
public class Divide {

    public int divide(int dividend, int divisor) {
        if(dividend > Integer.MAX_VALUE || dividend< -Integer.MAX_VALUE){
            return 2147483647;
        }
        Boolean fuFlag = false;
        if(divisor < 0){
            //除数是负的
            divisor = divisor-divisor-divisor;
            fuFlag = true;
        }
        if(dividend < 0){
            //被除数是负的
            dividend = dividend-dividend-dividend;
            fuFlag = !fuFlag;
        }

        //此时都是正数了
        Integer res = 0;
        res = digui(dividend, divisor, res);
        if(fuFlag){
            res = res - res - res;
        }
        return res;
    }


    public int digui(int dividend, int divisor, int res) {
        if(dividend < divisor){
            return res;
        }
        Integer curDiv=divisor;
        while (dividend >= curDiv + curDiv) {
            if(curDiv > Integer.MAX_VALUE>>1){
                break;
            }
            curDiv = curDiv + curDiv;
            res = res == 0 ? 1 : res + res;
        }
        int result = digui(dividend - curDiv, divisor, res);

        return res+result;
    }

    public static void main(String[] args) {
//        System.out.println(new Divide().divide(2147483647,1));
        System.out.println(new Divide().divide(10,2));
//        System.out.println(new Divide().divide(10,3));
    }
}
