package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * zhangyuxiao
 * 2020/10/19 14:07
 *
 * 给定一组非负整数 nums，重新排列它们每位数字的顺序使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数
 */
public class LargestNumbers {
    public String largestNumber(int[] nums) {
        String[] numsArray = new String[nums.length];
        for (int i = 0; i <nums.length; i++) {
            numsArray[i] = String.valueOf(nums[i]);
        }
        List<String> list = Arrays.asList(numsArray);
        Collections.sort(list,(o1,o2)->{return 0-(o1+o2).compareTo(o2+o1);});

        StringBuffer buffer = new StringBuffer();
        for (String s : list) {
            buffer.append(s);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumbers().largestNumber(new int[]{3,10,2,4}));
    }
}
