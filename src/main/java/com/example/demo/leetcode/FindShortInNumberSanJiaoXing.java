package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/14 14:12
 *
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上
 *
 * 思路：
 * 我们给每一个位置标上坐标
 *      2       (0,0)
 *     3 4   (1,0) (1,1)
 *    6 5 7      ...
 *   4 1 8 3     ...
 *   我们用f(i,j)表示从(i,j)位置一直到三角形底部的最小路径和。
 *   那么f(0,0) = min(f(1,0),f(1,1))+Value(0,0); Value(0,0)就是值2
 *   f(1,0) = min(f(2,0),f(2,1))+Value(1,0);
 *    ...
 *   1.推导出状态转移方程:
 *   f(i,j) = min(f(i+1,j),f(i+1,j+1)) + Value(i,j)。
 *   利用这个状态转移方程我们可以写出一个递归函数。
 *   2.递归的边界确定:
 *   对于f(i,j),当:
 *   i == 三角形高度-1 的时候，直接返回Value(i,j)
 */
public class FindShortInNumberSanJiaoXing {
    int[][] arr;
    public int find(int[][] arr,int i,int j) {
        this.arr = arr;
        return findLength(i, j);
    }

    public int findLength(int i, int j) {
        if (i == arr.length - 1) {
            return arr[i][j];
        }
        if (i > arr.length-1 || j > arr[i].length - 1) {
            return Integer.MAX_VALUE;
        }

        return Math.min(findLength(i + 1,j), findLength(i + 1,j+1)) + arr[i][j];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        System.out.println(new FindShortInNumberSanJiaoXing().find(arr, 9, 9));
    }

}
