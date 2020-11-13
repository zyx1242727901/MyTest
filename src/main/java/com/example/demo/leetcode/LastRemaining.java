package com.example.demo.leetcode;

import java.util.LinkedList;

/**
 * zhangyuxiao
 * 2020/11/6 16:15
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        LinkedList<Integer> list = new LinkedList();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int curIndex = 0;
        while (list.size() > 1) {
            //求索引这个地方记住吧
            curIndex = (curIndex+m) %list.size() -1 ;
            curIndex = curIndex < 0 ? list.size() + curIndex : curIndex;
            list.remove(curIndex);
        }
        return list.get(0).intValue();
    }

    public static void main(String[] args) {
        new LastRemaining().lastRemaining(5, 3);

//        System.out.println(5%3);
//        System.out.println(3%3);
    }



}
