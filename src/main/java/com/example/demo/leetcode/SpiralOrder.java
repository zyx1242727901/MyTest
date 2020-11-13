package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/11/3 19:42
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, t = 0;
        int b = matrix.length-1;
        int r = matrix[0].length-1;

        int res[] = new int[matrix.length * matrix[0].length];
        int index =0;
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) {
                res[index++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }

            for (int i = t; i <= b; i++) {
                res[index++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i>=l ; i--) {
                res[index++] = matrix[b][i];
            }
            if (--b < t) {
                break;
            }

            for (int i = b; i >= t; i--) {
                res[index++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new SpiralOrder().spiralOrder(arr);
    }
}
