package com.example.demo.leetcode;

import java.math.BigInteger;
import java.util.Stack;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: -123
 * 输出: -321
 */
public class Reverse {

//    //利用栈
//    public int reverse(int x) {
//        Stack<Character> stack = new Stack<>();
//        String s = x + "";
//        Character signed = null;
//
//        char[] charArray = s.toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            if (i == 0 && !Character.isDigit(charArray[i])) {
//                signed = charArray[i];
//                continue;
//            }
//            stack.push(charArray[i]);
//        }
//
//        StringBuffer sb = new StringBuffer();
//        while (!stack.empty()) {
//            sb.append(stack.pop());
//        }
//        try {
//            return Integer.parseInt((signed == null ? "" : signed) + sb.toString());
//        }catch (Exception e){
//            return 0;
//        }
//    }

    //取模
    public int reverse(int x) {
        int mod = 0;
        int pre = 0;

        while (x != 0){
            mod = x%10;
            x = x/10;
            //考虑越界情况，
            if(pre > Integer.MAX_VALUE/10 || (pre == Integer.MAX_VALUE/10 && mod > Integer.MAX_VALUE%10)) {
                return 0;
            }else if(pre < Integer.MIN_VALUE/10 || (pre == Integer.MIN_VALUE/10 && mod < Integer.MIN_VALUE%10)) {
                return 0;
            }

            pre = pre * 10 + mod;
        }

        return pre;
    }


    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int reverse1 = reverse.reverse(-1534236469);

        System.out.println(reverse1);
    }
}
