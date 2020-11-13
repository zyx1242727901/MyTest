package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * zhangyuxiao
 * 2020/11/6 15:51
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int low = 0;
        int max = nums[0];
        int[] res = new int[nums.length-k+1];

        for (int i = 0; i <= nums.length - k; i++) {
            if (max == nums[i-1]) {
                int[] a = Arrays.copyOfRange(nums, i, i + k);
                Arrays.sort(a);
                max = a[a.length - 1];
            } else {
                max = Math.max(max, nums[i + k - 1]);
            }
            res[i] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        new MaxSlidingWindow().maxSlidingWindow(new int[]{1, -1}, 1);
    }
}
