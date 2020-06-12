package com.example.demo.leetcode;

import java.util.Stack;

public class FindMaxConsecutiveOnes {
//    public int findMaxConsecutiveOnes(int[] nums) {
//        Stack<Integer> stack = new Stack<Integer>();
//        Integer max = 0;
//        for (Integer integer : nums) {
//            if(integer == 0){
//                max = Math.max(max, stack.size());
//                stack.clear();
//            }else{
//                stack.push(integer);
//            }
//        }
//        return Math.max(max, stack.size());
//    }

    public int findMaxConsecutiveOnes(int[] nums) {
        Integer max = 0;
        Integer count = 0;
        for (Integer integer : nums) {
            if(integer == 0){
                max = Math.max(count, max);
                count = 0;
            }else{
                count++;
            }
        }
        return Math.max(max, count);
    }


    public static void main(String[] args) {
        System.out.println(new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}
