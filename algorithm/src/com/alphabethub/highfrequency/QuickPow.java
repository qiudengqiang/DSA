package com.alphabethub.highfrequency;

import java.util.LinkedList;

/**
 * 快速求幂
 */
public class QuickPow {

    public static void main(String[] args) {
        System.out.println(power(2, 4));
        LinkedList<Integer> list = new LinkedList<>();
        Integer last = list.removeLast();
    }

    /**
     * 这个思想优于for循环，复杂度是log级别
     *
     * @param a
     * @param k
     * @return
     */
    static int power(int a, int k) {
        if (k == 0) return 1;
        if (k % 2 == 1) {
            //k是奇数
            return (a * power(a, k - 1));
        } else {
            //k是偶数
            int sub = power(a, k / 2);
            return (sub * sub);
        }
    }
}
