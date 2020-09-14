package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/10 11:48
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之闻的相对位置不变。
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];

        int low = 0;
        int heigh = 1;
        int temp;
        while (heigh < nums.length && low < nums.length) {
            if (nums[low] % 2 == 0) {
                if (nums[heigh] % 2 != 0) {
                    temp = nums[low];
                    nums[low] = nums[heigh];
                    nums[heigh] = temp;
                    low++;
                }
            } else {
                low++;
            }
            heigh++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        int[] exchange = new Exchange().exchange(nums);
        for (int i : exchange) {
            System.out.print(i+"   ");

        }
    }
}
