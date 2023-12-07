package com.alphabethub.dp;

/**
 * 最长公共子串(子串是连续的，子序列可以不连续)
 */
public class LCS {
    public static void main(String[] args) {
        String str1 = "abcba",str2 = "babca";
        System.out.println(longestCommonSubString(str1, str2));
    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * @param str1
     * @param str2
     * @return
     */
    static int longestCommonSubString(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}