package com.example.demo.leetcode;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Handler;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 */
public class ValidKuoHao {
    //实验1
//    public boolean isValid(String s) {
//        if(s != null && s.length() <= 0){
//            return true;
//        }
//
//        Map<String, Integer> map = new HashMap<>();
//        map.put("(", 1);
//        map.put(")", -1);
//        map.put("{", 2);
//        map.put("}", -2);
//        map.put("[", 3);
//        map.put("]", -3);     //愚蠢，其实左括号根本不用放到map里，只验证右括号即可
//
//        Stack<Integer> stack = new Stack();
//        String[] split = s.split("");
//        for (String s1 : split) {
//            if(map.containsKey(s1)){
//                Integer val = map.get(s1);
//                if(!stack.empty() && stack.peek() == val*-1){
//                    stack.pop();
//                    continue;
//                }
//                stack.push(val);
//            }
//        }
//
//        return stack.empty();
//    }

    public boolean isValid(String s) {
        if(s != null && s.length() <= 0){
            return true;
        }

        Map<Character, Character> map = new HashMap<>();

        map.put('}', '{');
        map.put(')','(');
        map.put(']', '[');

        Stack<Character> stack = new Stack();
        char[] split = s.toCharArray();
        for (char s1 : split) {
            if(!map.containsKey(s1)){
                stack.push(s1);
            }else{
                if(stack.empty() || !stack.pop().equals(map.get(s1))){
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        ValidKuoHao validKuoHao = new ValidKuoHao();
        boolean valid = validKuoHao.isValid("({[]})");
        System.out.println(valid);
    }
}
