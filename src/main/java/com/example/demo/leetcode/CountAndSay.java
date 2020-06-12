package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串
 *
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 *
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 *
 */
public class CountAndSay {

//    public String countAndSay(int n) {
//        if(n == 1){
//            return "1";
//        }
//        List<String> list = new ArrayList<>();
//        list.add("0");
//        list.add("1");
//        list.add("11");
//
//        for (int i = 3; i <= n; i++) {
//            String s = list.get(i - 1);
//            int count = 1;
//            char key = s.charAt(0);
//            StringBuffer curStr = new StringBuffer("");
//            for (int j = 1; j < s.length(); j++) {
//                if (s.charAt(j) == key) {
//                    count++;
//                }else{
//                    curStr.append(count + "" + key);
//                    count = 1;
//                    key = s.charAt(j);
//                }
//            }
//            curStr.append(count + "" + key);
//            list.add(curStr.toString());
//        }
//        return list.get(n);
//    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));

    }

    private String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n ; i++) {
            //遍历前一个字符串
            String currentStr = new String(ans);
            ans.delete(0,ans.length());
            int num = 0;
            char currentChar = currentStr.charAt(0);
            for (char c : currentStr.toCharArray()) {
                if(c == currentChar){
                    num++;
                }
                else{
                    ans.append((char)('0'+num));
                    ans.append(currentChar);
                    currentChar = c;
                    num = 1;
                }
            }
            ans.append((char)('0'+num));
            ans.append(currentChar);
        }

        return ans.toString();

    }
}
