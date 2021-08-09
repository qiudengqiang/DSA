package com.alphabethub.exam.hwl;

public class Solution {

    public static void main(String[] args) {
        System.out.println(edit_string("abcXYZdef", 3));
    }

    public static String edit_string(String str, int k) {
        if (str == null || str.length() == 0) return null;
        char[] chars = str.toCharArray();
        if (k > chars.length) return null;
        String sub = String.valueOf(chars, 0, k);
        String sub2 = String.valueOf(chars, k, chars.length - k);
        return sub2 + sub;
    }
}
