package com.example.demo.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Search {

    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        //找最小点
        int lowestIndex = nums.length > 1 ? diguiMin(nums) : 0;
        System.out.println(lowestIndex);
        if(target == nums[lowestIndex]){
            return lowestIndex;
        } else if (target >= nums[0] && lowestIndex > 0 && target <= nums[lowestIndex - 1]) {
            //左边
            return diguiTarget(0, lowestIndex == 0 ? 0 : lowestIndex - 1, nums, target);
        } else {
            //右边
            return diguiTarget(lowestIndex < nums.length - 1 ? lowestIndex + 1 : nums.length - 1, nums.length - 1, nums, target);
        }
    }

    int diguiMin(int[] nums){
        if(nums.length == 1 || nums[0] < nums[nums.length-1]){
            return 0;
        }

        int heigh = nums.length-1;
        int low = 0;
        while(low <= heigh){
            int mid = (heigh+low)/2;

            if (nums[mid] > nums[heigh] && mid != low) {
                //后一部分乱序，包含旋转点
                low = mid;
            } else if (nums[mid] < nums[heigh] && mid != heigh){
                heigh = mid;
            } else {
                return mid+1;
            }
        }
        return -1;
    }

    int diguiTarget(int low, int heigh, int[] nums, int target){
        while (low <= heigh){
            int mid = (heigh+low)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                heigh = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new Search().search(nums, 1));

    }

}
