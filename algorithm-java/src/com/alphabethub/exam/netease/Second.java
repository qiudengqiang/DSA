package com.alphabethub.exam.netease;

import com.alphabethub.api.map.HashMap;

public class Second {
    private static HashMap<Character, Character> map = new HashMap<>();

    static {
        for (int i = 1; i <= 26; i++) {
            char c = (char) ('A' + 32 + i - 1);
            char c2 = (char) ('Z' + 32 - i + 1);
            map.put(c, c2);
        }
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(26, 11));
    }

    public static char findKthBit(int n, int k) {
        char[] L = new char[n + 1];
        for (int i = 1; i < L.length; i++) {
            L[i] = (char) ('A' + 32 + i - 1);
        }
        String[] s = new String[n + 1];
        for (int i = 1; i < s.length; i++) {
            if (i == 1) {
                s[i] = "a";
            } else {
                s[i] = s[i - 1] + L[i] + reverse(invert(s, i - 1));
            }
            System.out.println(s[i]);
        }

        System.out.println("--");
        return s[n].charAt(k - 1);
    }

    public static String invert(String[] s, int index) {
        char[] chars = s[index].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = map.get(chars[i]);
        }
        return new String(chars);
    }

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[chars.length - i - 1];
        }
        return new String(chars);
    }

}
