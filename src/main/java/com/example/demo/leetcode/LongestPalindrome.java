package com.example.demo.leetcode;

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
    public String longestPalindrome(String s) {
        int length = 0;
        int left = 0;
        int right = 0;

        if(s == null || s.length() == 0){
            return "";
        }
        //依次遍历节点，获取i为中心与(i,i+1)为中心构成的回文最大值
        for (int i=0;i<s.length();i++) {
            //i为中心的回文长度
            int len1 = getLen(s, i, i);
            //(i,i+1)为中心的回文长度
            int len2 = getLen(s, i, i+1);
            //二者最大值
            int max = Math.max(len1,len2);
            if(max >length){
                length = max;
                left = i - (max-1)/2;
                right = i + max/2;
            }
        }
        return s.substring(left,right+1);
    }

    private int getLen(String s, int left, int right){
        //如果左边和右边节点相等，则继续往两边扩散
        while (left >= 0 && right< s.length() && s.charAt(left) == s.charAt(right))    {
            left--;
            right++;
        }
        return right - left - 1;
    }

    //动态规划
//    public String longestPalindrome(String s) {
//        if(s == null || s.length() == 0){
//            return "";
//        }
//
//
//        return null;
//    }


    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        System.out.println(palindrome.longestPalindrome("babaabd"));

    }
}

