package com.alphabethub.dp;

import java.util.Arrays;

/**
 * 300.求最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class _300_LIS {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 2, 2, 5, 1, 7, 101, 18}));
    }

    /**
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(n)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
