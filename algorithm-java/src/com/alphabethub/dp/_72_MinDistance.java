package com.alphabethub.dp;

/**
 * 72. 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class _72_MinDistance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        //base case ：某一个串为空的情况下，一定是对它需要做另外一个串的长度响应的insert次数
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //一起向前移动，步骤不增加
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //做insert、delete、replace操作，步骤数+1
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
