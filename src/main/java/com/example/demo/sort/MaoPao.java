package com.example.demo.sort;

/**
 * zhangyuxiao
 * 2020/11/16 16:48
 */
public class MaoPao {
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sort = new MaoPao().sort(new int[]{3, 2, 4, 56, 7, 1, 2, 0, 2});
        for (int i : sort) {
            System.out.println(i);
        }

    }
}
