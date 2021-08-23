package com.alphabethub.exam.netease;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrayStr = sc.nextLine();
        int target = sc.nextInt();
        String[] array = arrayStr.split(" ");
        System.out.println(findSumTarget(array, target));
    }

    public static int findSumTarget(String[] array, int target) {
        int pairCount = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                Integer i1 = Integer.valueOf(array[i]);
                Integer j2 = Integer.valueOf(array[j]);
                if (i1 + j2 <= target && i != j) {
                    pairCount++;
                }
            }
        }
        return pairCount;
    }

}
