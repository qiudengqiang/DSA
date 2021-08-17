package com.alphabethub.exam.dzy;

import java.util.Stack;

/**
 * 解压缩字符串
 * 压缩字符串规则如下：
 * 1. 如果字母x连续出现n次，则表示为(a)n
 * 2. 可以嵌套，比如((a)2(b)2)2，表示的是aabbaabb的结果
 * 3. 只出现一次的字母不进行压缩，a压缩后结果仍然是a
 */
public class Solution {
    public static void main(String[] args) {
        String str = "(a)2(b)2(c)2";
        String str2 = "((a)2(b)2)2";

    }

    public int categoryOfMaxWarehouseArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col - 1];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        return dp[rows-1][cols-1];
    }
}
