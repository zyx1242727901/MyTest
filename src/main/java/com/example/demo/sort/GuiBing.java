package com.example.demo.sort;

/**
 * zhangyuxiao
 * 2020/11/16 19:42
 */
public class GuiBing {
    //每次排序只要插入到前方有序的集合即可
    public int[] sort(int[] arr) {
        int[] copy = new int[arr.length];
        return sort(arr, copy, 0, arr.length - 1);
    }

    public int[] sort(int[] arr, int[] copy, int low, int heigh) {
        if (low >= heigh) {
            return arr;
        }
        int mid = (low + heigh) / 2;
        sort(arr, copy, low, mid);
        sort(arr, copy, mid + 1, heigh);
        return mergeSort(arr, copy, low, heigh, mid);
    }

    //类似合并两个有序列表
    public int[] mergeSort(int[] arr, int[] copy, int low, int heigh, int mid) {
        int star1 = low, end1 = mid;
        int star2 = mid+1, end2 = heigh;
        int index = low;

        while (star1 <= end1 && star2 <= end2) {
            copy[index++] = arr[star1] < arr[star2] ? arr[star1++] : arr[star2++];
        }
        while (star1 <= end1) {
            copy[index++] = arr[star1++];
        }
        while (star2 <= end2) {
            copy[index++] = arr[star2++];
        }
        for (int i = low; i <= heigh; i++) {
            arr[i] = copy[i];
        }
        return arr;
    }



    public static void main(String[] args) {
        int[] sort = new GuiBing().sort(new int[]{3, 2, 4, 56, 7, 1, 2, 0, 2});
        for (int i : sort) {
            System.out.println(i);
        }
    }
}
