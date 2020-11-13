package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/23 19:39
 *
 * 你面前有一栋从 1 到 N 共 N 层的楼，然后给你 K 个鸡蛋（K 至少为 1）。现在确定这栋楼存在楼层 0 <= F <= N，在这层楼将鸡蛋扔下去，
 * 鸡蛋恰好没摔碎（高于 F 的楼层都会碎，低于 F 的楼层都不会碎）。现在问你，最坏情况下，你至少要扔几次鸡蛋，才能确定这个楼层 F 呢？
 */
public class SuperEggDrop {
    public int[][] memo = null;

    public int superEggDrop(int K, int N) {
        memo = new int[K+1][N+1];
        return dp(K, N);
    }

    public int dp(int k, int n) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        if (memo[k][n] != 0) {
            return memo[k][n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(Math.max(dp(k, n - i), dp(k - 1, i - 1)) + 1, res);
        }
        memo[k][n] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SuperEggDrop().superEggDrop(1,2));
        System.out.println(new SuperEggDrop().superEggDrop(2,6));
        System.out.println(new SuperEggDrop().superEggDrop(6,5000));
    }
}
