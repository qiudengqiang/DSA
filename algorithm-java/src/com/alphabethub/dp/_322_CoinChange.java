package com.alphabethub.dp;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class _322_CoinChange {

    public static void main(String[] args) {
        int[] coins = {25, 20, 5, 1};
        System.out.println(coinChange(41, coins));
    }

    static int coinChange(int n, int[] coins) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) continue;
                if (dp[i - coin] >= min) continue;
                min = Math.min(dp[i - coin], min);
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }

    /**
     * 自底向上，递归，动态规划
     *
     * @return
     */
    static int coinChange(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1) min = Math.min(dp[i - 1], min);
            if (i >= 5) min = Math.min(dp[i - 5], min);
            if (i >= 20) min = Math.min(dp[i - 20], min);
            if (i >= 25) min = Math.min(dp[i - 25], min);
            dp[i] = min + 1;
        }
        return dp[n];
    }

    /**
     * 暴力递归，自顶向下
     * 使用记忆优化重复计算
     */
    static int coinChange2(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        int[] coins = {25, 20, 5, 1};
        for (int coin : coins) {
            dp[coin] = 1;
        }
        return coinChange2(dp, n);
    }

    static int coinChange2(int[] dp, int n) {
        if (n < 1) return Integer.MAX_VALUE;//Integer.MAX_VALUE必须用这个
        if (dp[n] == 0) {
            int min1 = Math.min(coinChange2(dp, n - 25), coinChange2(dp, n - 20));
            int min2 = Math.min(coinChange2(dp, n - 5), coinChange2(dp, n - 1));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }

    /**
     * 暴力递归 自顶向下
     *
     * @param n
     * @return
     */
    static int coinChange1(int n) {
        if (n < 1) return Integer.MAX_VALUE;//Integer.MAX_VALUE 算作一个递归基，处理负数的情况
        if (n == 1 || n == 5 || n == 20 || n == 25) return 1;//特殊递归基处理

        int min1 = Math.min(coinChange1(n - 25), coinChange1(n - 20));
        int min2 = Math.min(coinChange1(n - 5), coinChange1(n - 1));

        return Math.min(min1, min2) + 1;
    }


}
