package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 */
public class LengthOfLongestSubstring {

//    public int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        int i=0, j = 0;
//        HashSet<Character> set = new HashSet<>();
//
//        while(i < s.length() && j < s.length()){
//            if (!set.contains(s.charAt(j))) {
//                set.add(s.charAt(j));
//                j++;
//                maxLength = Math.max(maxLength, j - i);
//            }else{
//                set.remove(s.charAt(i));    //包含就一直移除，直到不包含为止
//                i++;
//            }
//        }
//
//
//        return maxLength;
//    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int i=0, j = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
//                i = map.get(s.charAt(j)) ;
                //左指针指向当前右指针的重复元素的下标，因为重复元素的下标之前所有元素到右指针形成的的字符串仍会与右指针元素重复
                //之所以用max是因为防止后续重复值的下标在当前i之前，因此用max保证不会重复检索
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j-i+1);
            map.put(s.charAt(j),++j); //此处put操作会覆盖重复的，所以contain时不用remove
        }


        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();
        int length = s.lengthOfLongestSubstring("abbaaabcdb");
        System.out.println(length);

    }
}
