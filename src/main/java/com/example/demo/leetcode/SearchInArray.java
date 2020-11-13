package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/11/4 18:43
 */
public class SearchInArray {
    public int search(int[] nums, int target) {
        return search2(nums, target, 0, nums.length - 1);
    }

    public int search2(int[] nums, int target, int lowIndex, int heighIndex) {
        int mid = (lowIndex + heighIndex) / 2;
        int count = 0;
        if (nums[mid] == target) {
            int low = mid, heigh = mid + 1;
            while (low >= lowIndex && nums[low] == target) {
                count++;
                low--;
            }
            while (heigh <= heighIndex && nums[heigh] == target) {
                count++;
                heigh++;
            }
            return count;
        } else if (nums[mid] > target) {
            if (nums[mid - 1] < target) {
                return 0;
            }
            return search2(nums, target, lowIndex, mid - 1);
        } else {
            if (nums[mid + 1] > target) {
                return 0;
            }
            return search2(nums, target, mid + 1, heighIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SearchInArray().search(new int[]{5,7,7,8,8,10}, 6));
    }
}
