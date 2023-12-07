package com.alphabethub.array;

import java.util.Arrays;

/**
 * 977.有序数组的平方 TODO
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class _977_SortedArraySquares {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(squares(nums)));
    }


    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int[] squares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (nums[i] * nums[i]);
        }
        Arrays.sort(nums);
        return nums;
    }
}
