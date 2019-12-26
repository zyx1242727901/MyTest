package com.example.demo.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionTwoSum {

//           递归start====================================
//    private int target = 0;

//    public int[] twoSum(int[] nums, int target) {
//        this.target = target;
//
//        for (int i = 0; i<nums.length; i++){
//            int index = findNum(nums[i], nums, i, i + 1);
//            if(index >= 0){
//                return new int[]{i,index};
//            }
//        }
//        return new int[]{-1, -1};
//    }
//
//    private int findNum(int curNum, int[] nums, int curIndex, int index) {
//        if(index > nums.length-1 || index < 0){
//            return -1;
//        }
//
//        if(curNum + nums[index] == target && curIndex != index){
//            return index;
//        }
//
//        return findNum(curNum, nums, curIndex, index + 1);
//    }
//           递归ennd====================================

//         no递归    start=====================
//        version 1
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i<nums.length; i++){
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
                j++;
            }
        }
        return result;
    }


//    version 2  可惜这个是求下标而不是求值，否则排序指针法还是很好用的
//    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        Arrays.sort(nums);
//
//        int i=0;
//        int j = nums.length - 1;
//        while (i < j) {
//            if (nums[i] + nums[j] == target) {
//                result[0] = nums[i];
//                result[1] = nums[j];
//                break;
//            } else if(nums[i] + nums[j] < target){
//                i++;
//            } else {
//                j--;
//            }
//        }
//        return result;
//    }

//          no递归    end=====================

    public static void main(String[] args) {
        int[] nums = new int[]{3,3};
        int target = 6;
        SolutionTwoSum solution = new SolutionTwoSum();
        int[] twoSum = solution.twoSum(nums, target);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }
}
