package com.alphabethub.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class _239_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;
        int[] maxes = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        for (int ri = 0; ri < nums.length; ri++) {
            while (!deque.isEmpty() && nums[ri] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(ri);

            //检查窗口的索引是否合法
            int li = ri - k + 1;
            if (li < 0) continue;

            // 检查队头的合法性
            if (deque.peekFirst() < li) {
                deque.pollFirst();
            }

            // 设置窗口的最大值
            maxes[li] = nums[deque.peekFirst()];
        }
        return maxes;
    }
}
