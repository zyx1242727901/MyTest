package com.example.demo.leetcode;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int j = 0;//记录第一个可赋值的索引
        for (int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                if (j != i) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                //等于0时，该索引不++，不等于0时往后移
                j++;
            }
        }

//        for (int num : nums) {
//            System.out.print(num+",");
//        }
//        System.out.println("=======================");
    }

    public static void main(String[] args) {
        new MoveZeros().moveZeroes(new int[]{0,2,3,5,0,1});
        new MoveZeros().moveZeroes(new int[]{1,2,0,5,0,1});
        new MoveZeros().moveZeroes(new int[]{1,2,0,5,0,1,0});
    }
}
