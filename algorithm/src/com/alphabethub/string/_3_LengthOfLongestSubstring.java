package com.alphabethub.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class _3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        int max = 0;//记录最长长度
        while (right < chars.length) {
            char c1 = chars[right];
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            right++;
            //如果window内出现重复字符，开始移动left缩小窗口
            while (window.get(c1) > 1) {
                char c2 = chars[left];
                window.put(c2, window.getOrDefault(c2, 0) - 1);
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
