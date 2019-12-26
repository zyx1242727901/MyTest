package com.example.demo.leetcode;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
//    public String longestPalindrome(String s) {
//        int length = 0;
//        int left = 0;
//        int right = 0;
//
//        if(s == null || s.length() == 0){
//            return "";
//        }
//
//        for (int i=0;i<s.length();i++) {
//            int len1 = getLen(s, i, i);
//            int len2 = getLen(s, i, i+1);
//            int max = Math.max(len1,len2);
//            if(max >length){
//                length = max;
//                left = i - (max-1)/2;
//                right = i + max/2;
//            }
//        }
//        return s.substring(left,right+1);
//
//    }
//
//    private int getLen(String s, int left, int right){
//        while (left >= 0 && right< s.length() && s.charAt(left) == s.charAt(right))    {
//            left--;
//            right++;
//        }
//        return right - left - 1;
//    }

    //动态规划
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }


        return null;
    }


    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        System.out.println(palindrome.longestPalindrome("babaabd"));

    }
}

