package me.techbird.recursion;

import me.techbird.tool.Times;

/**
 * 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class _509_FibonacciNumber {
    //eg:   0 1 2 3 4 5 6
    //ru le: 0 1 1 2 3 5 8
    //规则：下一个数，是前面两个数相加，求第n个相加的和
    public static void main(String[] args) {
        int n = 40;
        Times.test("fib", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib(n));
            }
        });
        Times.test("fib1", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib1(n));
            }
        });
        Times.test("fib2", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(n));
            }
        });
        Times.test("fib3", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib3(n));
            }
        });
        Times.test("fib4", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib4(n));
            }
        });
        Times.test("fib5", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib5(n));
            }
        });
        Times.test("fib6", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib6(n));
            }
        });
    }

    //递归方式
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    //递归方式利用数组优化空间复杂度为O(N)
    public static int fib1(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib1(n, array);
    }

    public static int fib1(int n, int[] array) {
        if (array[n] == 0) {
            array[n] = fib1(n - 1, array) + fib1(n - 2, array);
        }
        return array[n];
    }


    //非递归方式利用数组优化空间复杂度为O(n)
    public static int fib2(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    //非递归方式数组之滚动数组优化空间复杂度为O(1)
    public static int fib3(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }
        return array[n % 2];
    }


    /**
     * 非递归方式数组之滚动数组优化空间复杂度为O(1)，去掉%模运算
     * % 2 的操作都可以改为 & 1 (实际上是看二进制的最低位)
     *
     * @param n
     * @return
     */
    public static int fib4(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 1];
    }


    //非递归方式去掉数组之优化空间复杂度为O(1)
    public static int fib5(int n) {
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

    /**
     * 更简洁的写法
     *
     * @param n
     * @return
     */
    public static int fib6(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
