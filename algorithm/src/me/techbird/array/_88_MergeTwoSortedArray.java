package me.techbird.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class _88_MergeTwoSortedArray {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    //解法一：利用系统的快速排序，时间复杂度套用快排的即可：O((m+n)\log(m+n))
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 || n == 0) return;
        //合并
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        //排序
        Arrays.sort(nums1);
    }

    //解法二：时间复杂度 O(m+n)
    public static void merge(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return;

        int m = nums1.length - 1;
        int n = nums2.length - 1;
        int len = m + n - 1;

        while (m >= 0 && n >= 0) {
            nums1[len--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
//        System.arraycopy();
        for (int i = 0; i < n + 1; i++) {
            nums1[i] = nums2[i];
        }
    }

}
