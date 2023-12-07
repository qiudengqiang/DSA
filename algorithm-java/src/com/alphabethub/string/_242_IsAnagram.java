package com.alphabethub.string;

/**
 * 242. 有效的字母异位词
 * 题意解析：两个词汇中的单词出现频次相同，但位置不同。
 * https://leetcode-cn.com/problems/valid-anagram/
 * 解题思路：1.利用hashmap做映射；2：自建数组做映射
 * 优化小技巧：能利用变量的地方不调用方法，例如：len,length()
 */
public class _242_IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (--counts[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

    /**
     * 优化代码:利用空间换时间
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        if (schars.length != tchars.length) return false;
        int[] counts = new int[26];
        for (int i = 0; i < schars.length; i++) {
            counts[schars[i] - 'a']++;
        }

        for (int i = 0; i < tchars.length; i++) {
            if (--counts[tchars[i] - 'a'] < 0) return false;
        }
        return true;
    }
}
