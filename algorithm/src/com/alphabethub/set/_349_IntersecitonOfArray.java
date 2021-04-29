package com.alphabethub.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 349.两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class _349_IntersecitonOfArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        Set<Integer> ret_set = new HashSet<>();
        Set<Integer> nums_set = new HashSet<>();

        for (int num : nums1) {
            nums_set.add(num);
        }

        for (int num : nums2) {
            if(nums_set.contains(num)) {
                ret_set.add(num);
            }
        }

        int temp[] = new int[ret_set.size()];
        int index = 0;
        for (int num : ret_set) {
            temp[index++] = num;
        }
        return temp;
    }
}
