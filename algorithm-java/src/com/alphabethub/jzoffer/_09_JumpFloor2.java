package com.alphabethub.jzoffer;

/**
 * JZ9 跳台阶扩展问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
 */
public class _09_JumpFloor2 {
    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @param target
     * @return
     */
    public int jumpFloorII(int target) {
        if (target == 0 || target == 1) return 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }
}
