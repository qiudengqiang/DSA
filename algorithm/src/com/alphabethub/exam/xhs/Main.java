package com.alphabethub.exam.xhs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] chars = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = sc.next();
            }
        }
        maxMovePlan(chars, n);
    }

    public static int maxMovePlan(String[][] grid, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int rest = Math.max(dp[i - 1][j], dp[i][j - 1]);
                int rest2 = Math.max(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(rest, rest2) + 1;
            }
        }
        return dp[n-1][n-1];
    }
}
