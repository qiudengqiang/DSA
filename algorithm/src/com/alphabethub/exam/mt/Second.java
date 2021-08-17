package com.alphabethub.exam.mt;

public class Second {
    public static void main(String[] args) {
        System.out.println(minInsertion("abaaca"));
        System.out.println(minInsertion("aba"));
    }

    private static int minInsertion(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }

    private static int minInsertion2(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[] dp = new int[n];
        int temp = 0;
        for (int i = n - 2; i >= 0; i--) {
            //记录dp[i+1][j-1]
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                temp = dp[j];
                if (s[i] == s[j]) {
                    //dp[i][j] = dp[i+1][j-1]
                    dp[j] = pre;
                } else {
                    //dp[i][j] = min(dp[i+1][j],dp[i][j-1])+1
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                }
                pre = temp;
            }
        }
        return dp[n - 1];
    }
}
