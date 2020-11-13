package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * zhangyuxiao
 * 2020/11/6 11:29
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        if (target == 1) {
            return new int[][]{{0, 1}};
        }
        //写个滑动窗口吧
        int heigh = (target & 1) == 1 ? (target / 2 + 1) : target / 2;//偶数的右边界到target/2-1即可

        Integer arr[] = new Integer[heigh+1];
        for (int i = 1; i <= heigh; i++) {
            arr[i] = i;
        }

        ArrayList<Integer[]> list = new ArrayList<>();
//        int res[][] = new int[heigh][];
//        int arrIndex = 0;

        int left = 1;
        int right = 2;
        int sum = left;
        while (right <= heigh && left<right) {
            if ((sum+=right) == target) {
                list.add(Arrays.copyOfRange(arr, left, right+1));
//                res[arrIndex++] = Arrays.stream(Arrays.copyOfRange(arr, left, right+1)).mapToInt(Integer::intValue).toArray();
            } else if(sum > target){
                //大于了target，左边界右移，由于右边肯定比左边大，所以一直要移到比下个元素剩余空间小为止
                while (sum > target ) {
                    sum -= left;
                    left++;

                    if (sum == target) {
                        list.add(Arrays.copyOfRange(arr, left, right+1));
//                        res[arrIndex++] = Arrays.stream(Arrays.copyOfRange(arr, left, right + 1)).mapToInt(Integer::intValue).toArray();
                    }
                }
            }
            right++;

        }
        int res[][] = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = Arrays.stream(list.get(i)).mapToInt(Integer::intValue).toArray();
        }
//        return list.toArray(int array[list.size()]);
        return res;
    }

    public static void main(String[] args) {
        int[][] continuousSequence = new FindContinuousSequence().findContinuousSequence(15);
        for (int[] ints : continuousSequence) {
            if (ints == null) {
                continue;
            }
            for (int anInt : ints) {
                System.out.print(anInt+"   ");
            }
            System.out.println();
        }
    }
}
