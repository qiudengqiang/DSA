package com.alphabethub.exam.bhyh;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(pair(nums, L, R));
    }

    private static int pair(int[] nums, int L, int R) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int pair = nums[i] + nums[j];
                if (i != j && pair >= L && pair <= R) {
                    count++;
                }
            }
        }
        return count/2;
    }
}
