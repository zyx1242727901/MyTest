package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/9 15:52
 */

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        char[] array = s.toCharArray();
        StringBuffer buffer = new StringBuffer("");
        for (char c : array) {
            if (c == ' ') {
                buffer.append("%20");
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }
}
