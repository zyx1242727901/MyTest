package com.example.demo.leetcode;

public class StringToInterge {
    public static int valueOf(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int curr = 0;
        char[] chars = s.toCharArray();
        int flag = 1;//1 正  -1 负
        double max = Math.pow(2, 31) - 1;
        double min = Math.pow(-2, 31);
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int temp = 0;
            //第一位判断正负
            if (i == 0 && (aChar == '-' || aChar=='+')) {
                if (aChar == '-') {
                    flag = -1;
                    continue;
                }
            } else {
                if (!Character.isDigit(aChar)) {
                    break;
                }
                temp = aChar - '0';
            }


            if (curr*flag < (min+temp)/10) {
                return (int)min;
            }
            if (curr*flag > (max-temp)/10) {
                return (int)max;
            }
            curr = curr * 10 + temp;
        }
        return curr * flag;
    }

    public static void main(String[] args) {
        System.out.println(StringToInterge.valueOf("-2147483649"));
    }
}
