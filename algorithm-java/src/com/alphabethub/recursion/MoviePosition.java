package com.alphabethub.recursion;

/**
 * 依次问前排自己是第几排，从而递归计算出自己在第几排。
 */
public class MoviePosition {
    public static void main(String[] args) {
        System.out.println(f(4));
    }

    public static int f(int n) {
        if (n == 1) return 1;
        return f(n - 1) + 1;
    }
}
