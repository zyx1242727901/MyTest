package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/9 14:58
 */

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix != null && matrix.length > 0) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                int[] curr = matrix[i];

                if (curr != null && curr.length > 0) {
                    if (curr[0] <= target) {
                        for (int j = 0; j < curr.length; j++) {
                            if (curr[j] == target) {
                                return true;
                            } else if (curr[j] > target) {
                                continue;
                            }
                        }
                    }
                }
            }
        }


        return false;
    }
    public boolean findNumberIn2DArray2(int[][] array, int target) {
        //基本思路从左下角开始找，这样速度最快
        int row = array. length-1;
        int column = 0;
        //当行数大于0，当前列数小于总列数时循环条件成立
        while ((row >= 0) && (column< array[0]. length)) {
            if (array[row][column] > target) {
                row--;
            } else if (array[row][column] < target) {
                column++;
            } else {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {
                        1,4,7,11,15}
                ,{
                2,5,8,12,19}
                ,{
                3,6,9,16,22}
                ,{
                10,13,14,17,24}
                ,{
                18,21,23,26,30}
        };


//        5
        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(matrix,5));
        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(matrix,11));
    }
}
