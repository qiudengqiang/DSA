package com.alphabethub.array;

import java.util.*;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 */
public class _169_MajorityElement {
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    /**
     * 思路：利用二叉堆优先队列
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n/2)
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int len = (nums.length + 1) >> 1;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(len, Comparator.comparingInt(item -> -item));
        for (int num : nums) {
            pQueue.offer(num);
            if (pQueue.size() > len)
                pQueue.poll();
        }
        return pQueue.poll();
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length >> 1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) > n) {
                return num;
            }
        }
        return -1;
    }
}
