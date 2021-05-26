package com.alphabethub.array;

import java.util.Arrays;

/**
 * 164.最大间距 TODO
 * https://leetcode-cn.com/problems/maximum-gap/
 */
public class _164_MaxGap {
    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(maxGap(nums));
    }

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int maxGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > max) {
                max = nums[i] - nums[i - 1];
            }
        }
        return max;
    }
}
