package me.techbird.leetcode.recursion;

public class MoviePosition {
    public static void main(String[] args) {
        System.out.println(f(19999));
    }

    public static int f(int n) {
        if (n == 1) return 1;
        return f(n - 1) + 1;
    }
}
