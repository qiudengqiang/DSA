package com.alphabethub.exam.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        Integer m = Integer.valueOf(split[0].split("=")[1]);
        Integer n = Integer.valueOf(split[1].split("=")[1]);
        String[] string1 = sc.nextLine().split(",");
        String[] string2 = sc.nextLine().split(",");
        int[] nums1 = Arrays.stream(string1).mapToInt(Integer::valueOf).toArray();
        int[] nums = new int[m + n];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        int[] nums2 = Arrays.stream(string2).mapToInt(Integer::valueOf).toArray();
        merge(nums, nums2, m, n);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void merge(int[] nums1, int[] nums2, int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n-1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
