package com.alphabethub.exam.tencent.two;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        char[] chars = sc.next().toCharArray();
        dp[0] = dp[1] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < chars.length; i++) {
            if (i < 1) continue;
            if (chars[i] != chars[i - 1]) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }


}
