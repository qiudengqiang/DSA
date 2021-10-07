package com.alphabethub.highfrequency;

import java.util.Arrays;

/**
 * 输入一个正数n，返回区间[2,n]中素数的个数
 * 素数定义：如果一个数只能被1和它本身整除（n%1==0,n%n==0），那么这个数就是素数
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }


    static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    /**
     * 判断整数n是否为质数
     *
     * @param n
     * @return
     */
    static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            //根据素数定义反向思考，存在其他的可以整除的因子
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * 优化，去除冗余计算
     *
     * @param n
     * @return
     */
    static int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
