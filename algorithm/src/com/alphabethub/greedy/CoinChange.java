package com.alphabethub.greedy;

import java.util.Arrays;

/**
 * 零钱兑换
 */
public class CoinChange {
    public static void main(String[] args) {
        Integer[] faces = {25, 10, 5, 1};
        int money = 41, coins = 0;
//        new CoinChange().coinChange1(Arrays.sort(faces),money, coins);
        Arrays.sort(faces, (Integer i1, Integer i2) -> i2 - i1);
        new CoinChange().coinChange(faces, money, coins);
    }


    void coinChange(Integer[] faces, int money, int coins) {
        int i = 0;
        while (i < faces.length) {
            if (money < faces[i]) {
                i++;
                continue;
            }
            money -= faces[i];
            coins++;
        }
        System.out.println(coins);
    }

    void coinChange1(Integer[] faces, int money, int coins) {
        for (int i = faces.length - 1; i >= 0; i--) {
            if (money < faces[i]) {
                continue;
            }
            money -= faces[i];
            coins++;
            i = faces.length; //这一步很关键
        }
        System.out.println(coins);
    }
}
