package com.alphabethub.exam.bhyh;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.next();
        }
        Map<String, Integer> map = new HashMap<>();
        for (String num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
