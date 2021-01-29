package me.techbird.array;


/**
 * 344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class _344_ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(s);
        System.out.println(reverseString(s));
    }

    public static char[] reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < (len >> 1); i++) {
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
        return s;
    }
}
