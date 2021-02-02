package me.techbird.heap;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/submissions/
 */
public class _215_KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        //默认就是小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < k) {
                heap.add(nums[i]);
            } else if (nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }
}
