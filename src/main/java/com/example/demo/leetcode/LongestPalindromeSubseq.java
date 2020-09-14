package com.example.demo.leetcode;

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 */
//动态规划：dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j) otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s == "") {
            return 0;
        }
        int length = s.length();
        //用一个二维数组表示 下标i 与下标j之间的最长回文子序列长度
        int[][] array = new int[length][length];

        for (int i = length-1; i >= 0; i--) {
            //自己与自己的回文子序列长度永远是1
            array[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                //如果i与j下标的字符相等，则当前ij下标之间的最长子序列值等于i、j前一位的值+2
                if (s.charAt(i) == s.charAt(j)) {
                    array[i][j] = array[i + 1][j - 1] + 2;
                } else {
                    //否则就是ij之前一位的 取最大值
                    array[i][j] = Math.max(array[i][j - 1], array[i + 1][j]);
                }
            }
        }

        return array[0][length-1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubseq().longestPalindromeSubseq("bbbab"));
    }
}
