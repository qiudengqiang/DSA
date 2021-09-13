package com.alphabethub.exam.tencent.one;

import java.util.Scanner;


public class Thrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            //人数
            int n = sc.nextInt();
            //船的最大载重
            int w = sc.nextInt();
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                int weight = sc.nextInt();
                weights[j] = weight;
            }
        }
    }

    public static void minBoards(int[] weights, int w) {
        System.out.println(weights.length);
    }
}
