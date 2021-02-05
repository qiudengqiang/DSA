package me.techbird.heap;

import java.util.*;

/**
 * 692. 前K个高频单词
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class _692_TopKFrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).equals(map.get(o2)) ? o2.compareTo(o1) : map.get(o2) - map.get(o1);
            }
        });

        for (String key : map.keySet()) {
            heap.offer(key);
            if (heap.size() > k) heap.poll();
        }


        List<String> list = new ArrayList();
        while (!heap.isEmpty()) list.add(heap.poll());
        return list;
    }
}
