package com.alphabethub.greedy;

import java.util.Arrays;

/**
 * 最优转载问题（加勒比海盗）
 */
public class Pirate {

    public static void main(String[] args) {
        Integer[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
        Arrays.sort(weights);
        int capacity = 30, weight = 0, count = 0;
        for (int i = 0; i < weights.length; i++) {
            int newWeight = weight + weights[i];
            if (newWeight < capacity) {
                weight += weights[i];
                count++;
            }
        }

        System.out.println(count);
    }


}
