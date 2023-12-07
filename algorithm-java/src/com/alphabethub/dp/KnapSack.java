package com.alphabethub.dp;

/**
 * 0-1背包问题
 */
public class KnapSack {

    public static void main(String[] args) {

    }
    public int knapsack(int[] weights, int[] values, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - weights[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i-1][w - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[N][W];
    }
}
