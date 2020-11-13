package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/11/6 15:20
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] split = s.split(" ");
        for (int i = 0; i < split.length / 2; i++) {
            String temp = split[i];
            split[i] = split[split.length - i- 1];
            split[split.length - i- 1] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            if (s1.trim().length() > 0) {
                sb.append(s1).append(" ");
            }
        }
        String substring = sb.toString().trim();
        return substring;
    }

    public static void main(String[] args) {
        new ReverseWords().reverseWords("a good   example");
    }
}
