package com.alphabethub.recursion;

import com.alphabethub.tool.Times;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class _70_ClimbStairs {

    public static void main(String[] args) {
        _70_ClimbStairs c = new _70_ClimbStairs();
        Times.test("climbStairs", () -> {
            System.out.println(c.climbStairs(44));
        });
        Times.test("climbStairs1", () -> {
            System.out.println(c.climbStairs1(44));
        });
        Times.test("climbStairs2", () -> {
            System.out.println(c.climbStairs2(44));
        });
        Times.test("climbStairs3", () -> {
            System.out.println(c.climbStairs3(44));
        });
    }

    /**
     * 暴力递归解法：时间复杂度O(2^n)，空间复杂度O(n)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    /**
     * 数组递归，用数组存放计算过的结果避免重复计算
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * <p>
     * 自顶向下的计算
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 2) return n;

        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;

        return climbStairs1(n, array);
    }

    public int climbStairs1(int n, int[] array) {
        if (array[n] == 0) {
            array[n] = climbStairs1(n - 1, array) + climbStairs1(n - 2, array);
        }
        return array[n];
    }

    /**
     * 数组非递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 自底向上的计算
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 2) return n;

        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;

        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /**
     * 优化空间复杂度为O(1)
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }


}
