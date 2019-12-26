package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 */
public class FindMedianSortedArrays {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//    }

    //有序数组归并排序
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int k = nums2.length;
        int[] nums3 = new int[n+k];

        int i =0;
        int j =0;
        int t = 0;
        while (i < n && j < k) {
            if(nums1[i] < nums2[j]){
                nums3[t++] = nums1[i++];
            }else if(nums1[i] > nums2[j]){
                nums3[t++] = nums2[j++];
            }else{
                nums3[t++] = nums1[i++];
            }
        }

        while(i<n){
            nums3[t++] = nums1[i++];
        }
        while(j < k){
            nums3[t++] = nums2[j++];
        }

        if(t%2 == 0){
            return (nums3[(t-1)/2] + nums3[t/2])/2.0;
        }
        return nums3[(t-1)/2];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2,5};

        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double medianSortedArrays = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
