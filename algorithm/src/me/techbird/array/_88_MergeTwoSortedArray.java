package me.techbird.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class _88_MergeTwoSortedArray {
    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
    }

    //解法一：利用系统的排序
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    //解法二：手写排序过程
    public static void mergeTwoSortedArray(int[] nums1, int m, int[] nums2, int n){
        //思路：先合并为一个数组，然后进行排序
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        //TODO - 排序算法，等学完排序之后来实现
    }
}
