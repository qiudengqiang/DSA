package com.alphabethub.exam.qax;

public class Solution {
    public int getMaximumResource(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        int res = grid[0][0];
        dp[0][0] = grid[0][0];
        for (int row = 0; row < rows; row++) {
            if (grid[row][0] <= 0) continue;
            dp[row][0] = dp[row - 1][0] + grid[row][0];
            res = Math.max(res, dp[row][0]);
        }
        for (int col = 0; col < cols; col++) {
            if (grid[0][col] <= 0) continue;
            dp[0][col] = dp[0][col - 1] + grid[0][col];
            res = Math.max(res, dp[0][col]);
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (grid[row][col] <= 0) continue;
                int v2 = Math.max(dp[row - 1][col], dp[row][col - 1]);
                dp[row][col] = v2 + grid[row][col];
                res = Math.max(res, dp[row][col]);
            }
        }
        return res;
    }
}
