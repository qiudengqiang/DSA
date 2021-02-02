package me.techbird.heap;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
public class _703_KthLargestElementInStream {
    //默认就是小顶堆
    private PriorityQueue<Integer> heap;
    private int k;

    public _703_KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.add(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}
