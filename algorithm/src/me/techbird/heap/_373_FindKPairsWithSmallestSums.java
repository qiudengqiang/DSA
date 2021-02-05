package me.techbird.heap;

import java.util.*;

/**
 * 373. 查找和最小的K对数字
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 */
public class _373_FindKPairsWithSmallestSums {

    /**
     * 利用了合并K个有序链表的思想，把链表的关系转换为数组的角标来处理。非常的巧妙
     * 时间复杂度：O()
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
            }
        });

        //如果不做这个判断，可能会导致34行nums2越界的问题。
        List<List<Integer>> result = new LinkedList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return result;
        }

        for (int i = 0; i < Math.min(k, nums1.length); i++) {//O(k / nums.length)
            heap.offer(new int[]{i, 0});
        }

        while (k > 0 && !heap.isEmpty()) {
            int[] pair = heap.poll();
            List<Integer> item = new ArrayList<>();
            item.add(nums1[pair[0]]);
            item.add(nums2[pair[1]]);
            if (pair[1] < nums2.length - 1) {
                heap.offer(new int[]{pair[0], pair[1] + 1});
            }
            result.add(item);
            k--;
        }
        return result;
    }


    /**
     * 暴力解法
     * 时间复杂度：O(mnlogk)
     * 空间复杂度：O(k)
     */
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                //构建大顶堆
                return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
            }
        });

        //O(n^2)
        for (int i = 0; i < Math.min(k, nums1.length); i++) {//m
            for (int j = 0; j < Math.min(k, nums2.length); j++) {//n

                //logk
                if (heap.size() == k && (nums1[i] + nums2[j]) > (heap.peek().get(0) + heap.peek().get(1))) {
                    break;
                }

                if (heap.size() == k) {
                    //logk
                    heap.poll();
                }

                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i]);
                pair.add(nums2[j]);
                heap.offer(pair);
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        while (!heap.isEmpty()) {
            result.add(0, heap.poll());
        }
        return result;
    }

}
