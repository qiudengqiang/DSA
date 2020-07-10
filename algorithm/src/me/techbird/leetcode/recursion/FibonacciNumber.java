package me.techbird.leetcode.recursion;

import me.techbird.leetcode.tool.Times;

public class FibonacciNumber {
    //eg:   0 1 2 3 4 5 6
    //ru le: 0 1 1 2 3 5 8
    //规则：下一个数，是前面两个数相加，求第n个相加的和
    public static void main(String[] args) {
        int n = 40;
        Times.test("fib1", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib(n));
            }
        });
        Times.test("fib2", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(n));
            }
        });
    }

    //递归方式
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    //非递归方式
    public static int fib2(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
