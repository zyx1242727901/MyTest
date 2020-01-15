package com.example.demo.leetcode;

import java.util.*;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class GenerateParenthesis {
    private Set<String> set = new HashSet<>();
    private Integer maxCount ;

    public List<String> generateParenthesis(int n) {
        maxCount = n*2;
        digui("",0,0);

        return new ArrayList<>(set);
    }
    //递归 1
    public void digui(String res, int leftCount, int rightCount){
        if(res.length() == maxCount){
            set.add(res);
            return;
        }
        //如果右括号大于左括号，则错了   如果左括号数大于n则也错了
        if(leftCount < maxCount/2){
            digui(res + "(",  leftCount + 1, rightCount);
        }
        if(rightCount < leftCount){
            digui(res + ")",  leftCount, rightCount + 1);
        }
    }

    //动态规划
//    简单来说，在求N个括号的排列组合时，把第N种情况（也就是N个括号排列组合）视为单独拿一个括号E出来，剩下的N-1个括号分为两部分，P个括号和Q个括号，P+Q=N-1，
//    然后这两部分分别处于括号E内和括号E的右边，各自进行括号的排列组合。
//    由于我们是一步步计算得到N个括号的情况的，所以小于等于N-1个括号的排列组合方式我们是已知的（用合适的数据结构存储，方便后续调用，且在存储时可利用特定数据结构实现题目某些要求，如排序，去重等），
//    且P+Q=N-1，P和Q是小于等于N-1的，所以我们能直接得到P个和Q个括号的情况，进而得到N个括号的结果！
//
//    这个算法主要的基点就是将排列组合的情况分为了括号内和括号外这两种情况，且仅存在两种情况！至于为什么，
//    原因在于楼主的算法的前提是单独拿出来的括号E的左边在N个括号所有排列组合情况中都是处于最左边，所以不存在括号位于括号E的左边的情况。
//    因此，N-1个括号（拿出了括号E）仅可能分布于括号E内和括号E外，分为两种子情况讨论！
    public List<String> dongtaiguihua(int n) {
        List<List<String>> list = new ArrayList<>();

        List<String> l0 = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l0.add("");
        l1.add("()");
        list.add(l0);
        list.add(l1);

        //外层循环代表当前括号总对数
        for (int i = 2; i <= n; i++) {
            List<String> curList = new ArrayList<>();
            //内层循环用来区分括号内和括号外的个数各种情况
            for (int j = 0; j < i; j++) {
                List<String> cur1 = list.get(j);
                //要保证i+j = n-1   此处可用i代表n，品一下
                List<String> cur2 = list.get(i-1-j);

                for (String s2 : cur2) {
                    for (String s1 : cur1) {
                        curList.add("(" + s1 + ")" + s2);
                    }
                }
            }
            list.add(curList);
        }
        return list.get(n);
    }

    public static void main(String[] args) {
        List<String> strings = new GenerateParenthesis().dongtaiguihua(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
