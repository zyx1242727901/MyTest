package com.example.demo.leetcode;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 *
 * 如果单单是轮询遍历，那这个题没什么意义，KMP太难了。。。。。。
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)){
            return -1;
        }

        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        int i = new StrStr().strStr(haystack, needle);
        System.out.println(i);

    }
}
