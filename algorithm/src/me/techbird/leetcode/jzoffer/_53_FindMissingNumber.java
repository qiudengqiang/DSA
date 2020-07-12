package me.techbird.leetcode.jzoffer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 */
public class _53_FindMissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        System.out.println(missingNumber(nums));
    }

    /**
     * 思路：定义两个指针，一个在前一个在后，同时向后移动。对比每次的数值差是否等于1，若不等于1则出现了缺数。
     * 要考虑一些首尾边界的情况，比如只给出了[1]，则需输出0；若给出了[0,1]，则需输出2；
     * 时间复杂度：O(n)
     * TODO：使用二分法来提高查询速度为 O(logn)
     */
    public static int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int result = -1;
        int i, j;
        if (nums[0] > 0) {
            return 0;
        }
        for (i = 0; i < nums.length; ++i) {
            if (i != nums.length - 1) {
                j = i + 1;
                if (nums[j] - nums[i] != 1) {
                    return nums[i] + 1;
                }
            } else {
                return nums[i] + 1;
            }
        }
        return result;
    }
}
