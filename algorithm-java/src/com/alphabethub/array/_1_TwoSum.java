package com.alphabethub.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class _1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] ints = twoSum3(nums, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.printf(ints[i]+" ");
        }
    }
    /**
     * 穷举法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        //不存在这两个数
        return new int[]{-1, -1};
    }

    /**
     * 利用空间换时间：使用哈希表优化时间复杂度
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[]{i, index.get(other)};
            }
        }
        //不存在这两个数
        return new int[]{-1, -1};
    }

    /**
     * 如果数组中的数据是有序的，可以受二分查找启发使用双指针的技巧
     * 时间复杂度：O（nlogn），但对于乱序的话如果排序则会改变元素本来的位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        //不存在这两个数
        return new int[]{-1, -1};
    }

}
