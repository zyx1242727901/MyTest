package com.example.demo.leetcode;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        fastSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    //快速排序
    public void fastSort(int[] nums,int low,int heigh){
        if (low < 0 || heigh >= nums.length || low >= heigh) {
            return;
        }
        int left = low;
        int right = heigh;
        int flagNum = nums[low];
        int temp = flagNum;
        while (left < right) {
            while (right > left && nums[right] >= flagNum) right--;
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }

            while (left<right && nums[left] <= flagNum) left++;
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = flagNum;

        fastSort(nums,low,left-1);
        fastSort(nums,left+1,heigh);
    }


    public static void main(String[] args) {
        int nums[] = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new FindKthLargest().findKthLargest(nums,4));
    }
}
