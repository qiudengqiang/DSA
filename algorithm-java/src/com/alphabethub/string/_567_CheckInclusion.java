package com.alphabethub.string;


import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class _567_CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] t = s2.toCharArray();
        for (int i = 0; i < t.length; i++) {
            needs.put(t[i], needs.getOrDefault(t[i], 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        char[] s = s1.toCharArray();
        while (right < s.length) {
            char c = s[right];
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }
            while (right - left >= t.length) {
                if (valid == needs.size()) return true;
                char d = s[left];
                left++;
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }

}
