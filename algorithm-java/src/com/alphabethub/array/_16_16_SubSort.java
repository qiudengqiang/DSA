package com.alphabethub.array;

import java.util.Arrays;

/**
 * 面试题_16_16_部分排序
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 */
public class _16_16_SubSort {
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 3, 2, 6, 7};
        System.out.println(Arrays.toString(subSort(nums)));
    }

    public static int[] subSort(int[] array) {
        if (array.length == 0) return new int[]{-1, -1};

        //从左到右扫描逆序对，正序：逐渐变大
        int max = array[0];
        //用于记录最右逆序对位置
        int r = -1;
        for (int i = 1; i < array.length; i++) {
            //判断一定要使用>=
            if (array[i] >= max) {
                max = array[i];
            } else {
                r = i;
            }
        }

        //数组有序，提前结束
        if (r == -1) return new int[]{-1, -1};

        //从右往左扫描逆序对，正序：逐渐变小
        int min = array[array.length - 1];
        //用于记录最左的逆序对位置
        int l = -1;
        for (int i = array.length - 2; i >= 0; i--) {
            //判断一定要使用<=
            if (array[i] <= min) {
                min = array[i];
            } else {
                l = i;
            }
        }

        return new int[]{l, r};
    }

}
