package com.example.demo.sort;

/**
 * zhangyuxiao
 * 2020/11/16 16:49
 */
public class XuanZe {
    //每次排序拿到最小的，交换位置，下次扫描只扫描本次index之后的即可（冒泡是每次全部扫）
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sort = new XuanZe().sort(new int[]{3, 2, 4, 56, 7, 1, 2, 0, 2});
        for (int i : sort) {
            System.out.println(i);
        }

    }
}
