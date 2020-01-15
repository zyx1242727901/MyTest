package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 */
public class LongestCommonPrefix {
//    public String longestCommonPrefix(String[] strs) {
//        if(strs.length == 0){
//            return "";
//        }
//        char[] charcter = strs[0].toCharArray();
//        for (int i = 1; i < strs.length; i++) {
//            String str = strs[i];
//            if (charcter.length == 0 || "".equals(str)) {
//                return "";
//            }
//
//            char[] chars = str.toCharArray();
//            for(int j=0;j<chars.length;j++){
//                if(charcter.length-1 < j){
//                    break;
//                } else if(charcter[j] != chars[j]){
//                    charcter = Arrays.copyOfRange(charcter,0,j);
//                    break;
//                } else {
//                    //相等判断是否是最后一个元素
//                    if (j == chars.length - 1) {
//                        charcter = chars;
//                    }
//                }
//            }
//        }
//        return charcter.length == 0 ? "" : String.copyValueOf(charcter);
//    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String temp = strs[i];
            while (temp.indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);

                if(prefix == null || prefix == ""){
                    return "";
                }
            }
        }
        return prefix;
    }


    public static void main(String[] args) {
//        System.out.println(String.copyValueOf(Arrays.copyOfRange(new char[]{'a','b','c'},0,3-1)));
        String s1 = "flower";
        String s2 = "flow";
        String s3 = "flight";

        String[] array = new String[]{"abab","aba",""};
//        String[] array = new String[]{s1,s2,s3};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(array));
    }
}
