package com.alphabethub.jzoffer;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class _47_MaxValue {
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        //0行0列的最大价值就是自己
        dp[0][0] = grid[0][0];

        //第0行的路径只有1种
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        }
        //第0列的路径只有1种
        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                //向右和向下2种路径走法
                dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
