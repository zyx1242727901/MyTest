package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionThreeClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minDist = Math.abs(nums[0] + nums[1] + nums[2]-target);
        int curSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int distinct = Math.abs(sum - target);
                if(distinct < minDist){
                    minDist = distinct;
                    curSum = sum;
                }

                if(sum > target){
                    k--;
                }else if(sum < target){
                    j++;
                }else{
                    return target;
                }
            }
        }
        return curSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4};
        int target = -1;
        SolutionThreeClosest solution = new SolutionThreeClosest();
        int sum = solution.threeSumClosest(nums, target);

        System.out.println(sum);

    }
}
