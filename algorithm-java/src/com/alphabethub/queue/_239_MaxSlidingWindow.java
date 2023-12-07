package com.alphabethub.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class _239_MaxSlidingWindow {

    /**
     * 暴力解法
     * 时间复杂度：O(nk)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        //窗口大小为1，直接返回数组本身即可
        if (k == 1) return nums;
        //滑动窗口的数量：nums.length-k+1
        int[] maxes = new int[nums.length - k + 1];

        //当前窗口的最大值索引
        int maxIdx = 0;
        //先求出前k个值的最大值索引
        for (int i = 1; i <= k; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        //li指向滑动窗口的第一个元素，ri指向滑动窗口的最后一个元素，窗口的大小为k
        for (int li = 0; li < maxes.length; li++) {
            int ri = li + k - 1;
            if (maxIdx < li) {//不在滑动窗口的合法范围内
                maxIdx = li;
                //求出[li,ri]范围内值最大的索引
                for (int i = li + 1; i <= ri; i++) {
                    if (nums[i] > nums[maxIdx]) maxIdx = i;
                }
            } else if (nums[ri] >= nums[maxIdx]) {//在滑动窗口的合法范围内
                maxIdx = ri;
            }

            maxes[li] = maxIdx;
        }
        return maxes;
    }

    /**
     * 双端单调队列的解法
     * 思路：保证队列从头到尾是单调（例如：从大到小）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param k 滑动窗口的大小
     * @return
     */
    public int[] maxSlidingWindow_deque(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;
        int[] maxes = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        for (int ri = 0; ri < nums.length; ri++) {
            //处理队尾的合法性
            while (!deque.isEmpty() && nums[ri] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //尾部入队
            deque.offerLast(ri);

            //检查窗口的li索引是否合法（保证大于0）
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
