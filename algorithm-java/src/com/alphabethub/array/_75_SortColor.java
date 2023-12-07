package com.alphabethub.array;

import java.util.Arrays;

/**
 * 75.颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class _75_SortColor {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColor(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 三指针技巧
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public static void sortColor(int[] nums) {
        int l = 0, r = nums.length - 1, cur = 0;
        while (cur <= r) {
            if (nums[cur] == 2) {
                swap(nums, cur, r--);
            } else if (nums[cur] == 0) {
                swap(nums, cur++, l++);
            } else {
                cur++;
            }
        }
    }

    private static void swap(int[] nums, int cur, int i) {
        int tmp = nums[cur];
        nums[cur] = nums[i];
        nums[i] = tmp;
    }
}
