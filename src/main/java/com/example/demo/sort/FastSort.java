package com.example.demo.sort;

/**
 * zhangyuxiao
 * 2020/11/16 19:38
 */
public class FastSort {
    public int[] sort(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    public int[] sort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        int low = left;
        int heigh = right;
        int key = arr[low];
        while (low < heigh) {
            while (low < heigh && arr[low] < key) low++;
            if (low < heigh) {//满足条件才交换
                arr[heigh] = arr[low++];
            }
            while (low < heigh && arr[heigh] < key) heigh--;
            if (low < heigh) {
                arr[low] = arr[heigh--];
            }
        }
        arr[heigh] = key;
        sort(arr, low, heigh - 1);
        sort(arr, heigh, right);
        return arr;
    }

    public static void main(String[] args) {
        int[] sort = new MaoPao().sort(new int[]{3, 2, 4, 56, 7, 1, 2, 0, 2});
        for (int i : sort) {
            System.out.println(i);
        }

    }
}
