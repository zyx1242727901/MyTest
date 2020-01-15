package com.example.demo.leetcode;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {
    private static Map<String,char[]> map = new HashMap<>();
    static {
        map.put("2", new char[]{'a', 'b', 'c'});
        map.put("3", new char[]{'d', 'e', 'f'});
        map.put("4", new char[]{'g', 'h', 'i'});
        map.put("5", new char[]{'j', 'k', 'l'});
        map.put("6", new char[]{'m', 'n', 'o'});
        map.put("7", new char[]{'p', 'q', 'r', 's'});
        map.put("8", new char[]{'t', 'u', 'v'});
        map.put("9", new char[]{'w', 'x', 'y','z'});
    }

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() > 0) {
            diGui("", digits);
        }
        return result;
    }

    public void diGui(String currStr, String digits){
        if(digits.length() == 0){
            result.add(currStr);
            return;
        }

        String substring = digits.substring(0,1);
        char[] chars = map.get(substring);
        for (char aChar : chars) {
            diGui(currStr+aChar,digits.substring(1));
        }
    }

    public static void main(String[] args) {
        List<String> strings = new LetterCombinations().letterCombinations("32");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
