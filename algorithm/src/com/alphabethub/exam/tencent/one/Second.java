package com.alphabethub.exam.tencent.one;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int maxEnergy = 0;
            for (int j = 0; j < n; j++) {
                maxEnergy += sc.nextInt() + j;
            }
            System.out.println(maxEnergy + 1);
        }
    }
}
