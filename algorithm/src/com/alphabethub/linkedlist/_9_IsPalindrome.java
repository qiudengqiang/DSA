package com.alphabethub.linkedlist;

/**
 * 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class _9_IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalidrome(112));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param x
     * @return
     */
    public static boolean isPalidrome(int x) {
        String string = String.valueOf(x);
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
