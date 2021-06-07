package com.alphabethub.string;

/**
 * 面试题 01.09. 字符串轮转
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 */
public class _0109_FlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        return (s1 + s2).contains(s2);
    }
}
