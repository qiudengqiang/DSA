package com.alphabethub.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 */
public class _451_SortCharactersByFrequency {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (Character c : map.keySet()) {
            heap.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            Character c = heap.poll();
            Integer count = map.get(c);
            for (Integer i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
