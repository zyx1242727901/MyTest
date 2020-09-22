package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/17 13:56
 *
 * 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 */
public class LongestCommonSubsequence {
    String t1 = null;
    String t2 = null;

    /**
     * 思路：
     * 用两个下标分别从头遍历两个字符串，用dp[i][j]表示t1[o~i]与t2[0~j]的最长公共子序列，
     * 若t1[i] == t2[j],则最长公共子序列+1，否则两者必然丢弃一个，即求max(dp(i-1,j),dp[i,j-1])
     * @param text1
     * @param text2
     * @return
     */
//    public int longestCommonSubsequence(String text1, String text2) {
//        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
//            return 0;
//        }
//        t1 = text1;
//        t2 = text2;
//        return lcs(t1.length() - 1, t2.length() - 1);
//    }
//    public int lcs(int i,int j){
//        if (i == -1 || j == -1) {
//            return 0;
//        }
//
//        if (t1.charAt(i) == t2.charAt(j)) {
//            return lcs(i - 1, j - 1) + 1;
//        } else {
//            return Math.max(lcs(i - 1, j), lcs(i, j - 1));
//        }
//    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        //长度为length+1，每个字富川从dp下标为1开始遍历，让dp【0】都为0，解决边界问题
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i=0;i < text1.length(); i++){
            for(int j=0;j < text2.length();j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[text1.length() ][text2.length() ];

    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abdcdklec","arcoe"));
    }
}
