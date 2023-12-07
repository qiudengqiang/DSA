package com.alphabethub.heap;


import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class _347_TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    /**
     * 时间复杂度：O(nlogk)
     * 空间复杂度：O(n)
     * TODO:如果使用桶排序可以吧时间复杂度优化到O(n)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer value = map.get(num);
                map.put(num, value + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Integer key : map.keySet()) {
            System.out.println(heap.peek());
            if (heap.size() < k) {
                heap.add(key);
            } else if (map.get(key) > map.get(heap.peek())) {
                heap.poll();
                heap.add(key);
            }
        }

        int[] rets = new int[k];
        int size = heap.size();
        for (int i = 0; i < size; i++) {
            rets[i] = heap.poll();
        }
        return rets;
    }
}
