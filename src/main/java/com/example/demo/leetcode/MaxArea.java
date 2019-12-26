package com.example.demo.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 原题：https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {
    /**
     * 思路：
     * 面积 = min(两条线.length)*两条线直间下标的长度
     * 可以用二分法
     */

    public int maxArea(int[] height) {
        int maxArea = 0;
        int low = 0;
        int high = height.length - 1;

        while (low < high) {
            int min = Math.min(height[low], height[high]);
            int area = min * (high - low);
            if(area > maxArea){
                maxArea = area;
            }
            //等于低下标则低下标自增，直到遇到一个比当前下标高的值
            if(height[low] == min) {
                int oldMin = height[low];
                low++;
                while (height[low] <= oldMin && high > low) {
                    low++;
                }
            }else {
                int oldMin = height[high];
                high--;
                while (height[high] <= oldMin && high>low) {
                    high--;
                }
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        MaxArea obj = new MaxArea();
        int maxArea = obj.maxArea(height);
        System.out.println(maxArea);

    }
}
