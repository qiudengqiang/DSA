package com.alphabethub.exam.xiaomi;

import java.util.HashMap;
import java.util.Map;

public class Third {
    public static void main(String[] args) {
        String str = "abcbca";
        System.out.println(subSequence(str));
    }

    /**
     * 返回给定字符串的子串，要求字符串首尾一致，长度最长。
     * @param s
     * @return
     */
    public static String subSequence(String s) {
        if(s == null || s.length() == 0) return null;
        if(s.length() == 1) return s;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int len = 1, left = 0, right = 1;
        for (int i = 0; i < chars.length; i++) {
            Integer pos = map.get(chars[i]);
            if (pos == null) {
                map.put(chars[i], i);
            } else if (i - pos > len) {
                len = i - pos;
                left = pos;
                right = i;
            }
        }
        return s.substring(left, right + 1);
    }
}
