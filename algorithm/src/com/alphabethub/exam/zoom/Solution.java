package com.alphabethub.exam.zoom;


import java.util.LinkedList;
import java.util.Deque;

public class Solution {
    /***
     * 指定窗口大小和步长
     * @param nums
     * @param windowSize
     * @param step
     * @return
     */
    public int[] slideWindow(int[] nums, int windowSize, int step) {
        if (nums == null || nums.length == 0 || windowSize < 1) return new int[0];
        if (windowSize == 1 && step == 1) return nums;
        int[] maxes = new int[nums.length - windowSize + 1];
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int ri = 0; ri < nums.length; ri += step) {
            while (!deque.isEmpty() && nums[ri] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(ri);
            int li = ri - windowSize + 1;
            if (li < 0) continue;

            if (deque.peekFirst() < li) {
                deque.pollFirst();
            }
            maxes[li] = nums[deque.peekFirst()];
        }
        return maxes;
    }

    /**
     * i<j<k,nums[i]<nums[j]<nums[k]，满足此条件的个数
     * @param nums
     * @return
     */
    public int find132Pattern(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
