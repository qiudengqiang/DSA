package com.alphabethub.exam.mt;

import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        String path = sc.next();
        int[] arr = new int[p];
        for (int i = 0; i < p; i++) {
            arr[i] = sc.nextInt();
        }
        if (p == 1) {
            System.out.println(arr[0]);
        } else {
            int sum = 0;
            for (int i = 0; i < p; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        }

    }
}
