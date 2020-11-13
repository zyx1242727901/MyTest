package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * zhangyuxiao
 * 2020/9/27 17:59
 *
 * [
 *  ["",""]
 * ]
 */
public class SolveNQueens {
    private int length = 0;
    private List<List<String>> resList = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        length = n;
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        huisu(0, chars);

        return resList;
    }

    public void huisu(int row,char[][] arr) {
//        base case
        if (row >= length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(new String(arr[i]));
            }
            resList.add(list);
            return;
        }

        //遍历每一列
        for (int i = 0; i < length; i++) {
            if (!checkValid(row, i, arr)) {
                continue;
            }
            //操作
            arr[row][i] = 'Q';
            huisu(row + 1, arr);
            //撤销操作
            arr[row][i] = '.';
        }
    }

    public boolean checkValid(int row, int col, char[][] arr){
        for (int i = 0; i < length; i++) {
            if ('Q' == arr[i][col]) {
                return false;
            }
        }

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < length; i--, j++) {
            if (arr[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new SolveNQueens().solveNQueens(4);
    }
}
