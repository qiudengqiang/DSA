package com.alphabethub.divideconquer;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class _53_MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(new _53_MaxSubArray().maxSubArray(nums));
        System.out.println(maxSubarray2(nums));
    }


    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length);
    }

    /**
     * 求解[begin, end)中最大连续子序列的和
     * T(n) = T(n/2) + T(n/2) + O(n)
     * T(n) = 2T(n/2) + O(n)
     * logba = 1  d = 1
     * 故是时间复杂度是O(nlogn)
     * 空间复杂度是O(logn)
     */
    int maxSubArray(int[] nums, int begin, int end) {
        if (nums == null || nums.length == 0) return 0;
        if (end - begin < 2) return nums[begin];//base case

        int mid = (begin + end) >> 1;

        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        return Math.max(leftMax + rightMax, Math.max(maxSubArray(nums, begin, mid), maxSubArray(nums, mid, end)));
    }

    /**
     * 暴力
     * 时间复杂度：O(N^3)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    static int maxSubarray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            for (int end = begin; end < nums.length; end++) {
                // sum是[begin, end]的和
                for (int i = begin; i < end; i++) {
                    sum += nums[end];
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    /**
     * 在暴力的基础上优化
     *
     * @param nums
     * @return
     */
    static int maxSubarray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            for (int end = begin; end < nums.length; end++) {
                sum += nums[end];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
