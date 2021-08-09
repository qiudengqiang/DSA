package com.alphabethub.exam.qax;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] height = {1, 5, 3, 2, 4};
        System.out.println(TeamNums(height));
        ;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param height int整型一维数组 舞蹈员身高的一维数组
     * @return int整型
     */
    public static int TeamNums(int[] height) {
        if (height == null || height.length < 3) return 0;
        Arrays.sort(height);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < height.length; i++) {
            set.add(height[i]);
        }
        List<Integer> integers = set.stream().collect(Collectors.toList());
        int groupNums = 0;
        int left = 0, right = 3;
        while (right < integers.size()) {
            while (left < right) {
                groupNums++;
                left++;
            }
            right++;
            left = right - 3;
        }
        return (groupNums / 3) + 1;
    }
}
