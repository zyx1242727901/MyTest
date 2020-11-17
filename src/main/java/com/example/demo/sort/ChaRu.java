package com.example.demo.sort;

/**
 * zhangyuxiao
 * 2020/11/16 16:49
 */
public class ChaRu {
    //每次排序只要插入到前方有序的集合即可
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sort = new ChaRu().sort(new int[]{3, 2, 4, 56, 7, 1, 2, 0, 2});
        for (int i : sort) {
            System.out.println(i);
        }

    }
}
