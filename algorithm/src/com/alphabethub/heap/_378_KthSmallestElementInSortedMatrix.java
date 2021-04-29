package com.alphabethub.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class _378_KthSmallestElementInSortedMatrix {
    /**
     *
     * 时间复杂度：O(nlogk)
     * TODO:使用二分查找是O(nlog(r-l))的时间复杂度
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //使用最大堆
                return o2 - o1;
            }
        });

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (heap.size() < k) {
                    heap.add(matrix[i][j]);
                } else if (matrix[i][j] < heap.peek()) {
                    heap.poll();
                    heap.add(matrix[i][j]);
                }
            }
        }
        return heap.peek();
    }
}
