package com.alphabethub.math;

import java.util.LinkedList;

/**
 * 372.超级次方
 * https://leetcode-cn.com/problems/super-pow
 */
public class _372_SuperPow {
    int base = 1337;

    public int superPow(int a, int[] b) {
        if (b.length == 0) return 1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : b) {
            list.add(i);
        }
        return myPow(a, list);
    }

    private int myPow(int a, LinkedList<Integer> list) {
        if (list.size() == 0) return 1;
        Integer last = list.removeLast();
        int part1 = power(a, last);
        int part2 = power(myPow(a, list), 10);
        return (part1 * part2) % base;
    }

    private int power(int a, Integer k) {
        if (k == 0) return 1;
        a %= base;
        if (k % 2 == 1) {
            //k是奇数
            return (a * power(a, k - 1)) % base;
        } else {
            //k是偶数
            int sub = power(a, k / 2);
            return sub * sub;
        }
    }
}
