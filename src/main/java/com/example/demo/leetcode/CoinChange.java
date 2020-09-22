package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/17 16:58
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 */
public class CoinChange {
    /**
     * base case: amount<=0；return -1；
     * 选择条件：硬币金额
     * 状态：金额amount
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                int intervel = i - coin;
                if (intervel < 0) {//无解，跳过
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[intervel]+1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        initMemo(amount);
        int res = dpM(coins, amount);
        return res == Integer.MAX_VALUE? -1:res;
    }

    //递归
    private int[] memo = null;
    public void initMemo(int amount){
        memo = new int[amount + 1];
        for (int i = 1; i < memo.length; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
    }
    public int dpM(int[] coins, int amount) {
        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        }

        //base
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int intervel = amount - coin;
            if (intervel < 0) {
                continue;
            }

            int dp = dpM(coins, intervel);
            res = Math.min(res, dp != Integer.MAX_VALUE ? dp + 1 : dp);
        }
        memo[amount] = res;
        return res;
    }



    public static void main(String[] args) {
//        System.out.println(new CoinChange().coinChange(new int[]{5, 5, 1}, 11));
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange1(new int[]{5, 5, 1},11));
    }
}
