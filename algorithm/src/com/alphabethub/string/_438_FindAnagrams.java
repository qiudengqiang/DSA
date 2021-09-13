package com.alphabethub.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class _438_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(needMap.get(c))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == needMap.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (needMap.containsKey(d)) {
                    if (windowMap.get(d).equals(needMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }
}
