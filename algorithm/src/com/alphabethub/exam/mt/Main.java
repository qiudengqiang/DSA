package com.alphabethub.exam.mt;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        for (int i = 0; i < groups; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(isSorted(nums) ? "Yes" : "No");
        }
    }

    /**
     * 判断是否有序，并且没有缺失数字，没有多余数字
     *
     * @param nums
     * @return
     */
    public static boolean isSorted(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 1) return false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) return false;
        }
        return true;
    }
}
