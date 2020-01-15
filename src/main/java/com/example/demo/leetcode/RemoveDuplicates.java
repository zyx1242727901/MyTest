package com.example.demo.leetcode;

import com.sun.tools.classfile.Opcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int heigh = 1,low=0;
        for (; heigh < nums.length; heigh++) {
            if (nums[heigh] != nums[low]) {
                low++;
                nums[low] = nums[heigh];
            }
        }
        return low+1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,1,2};
        System.out.println(new RemoveDuplicates().removeDuplicates(array));
    }
}
