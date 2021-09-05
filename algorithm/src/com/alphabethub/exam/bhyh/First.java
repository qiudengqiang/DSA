package com.alphabethub.exam.bhyh;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            s[i] = num;
            sum += num;
        }
        int average = sum / n;
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] > average) {
                count++;
            }
        }
        System.out.println(count);
    }
}
