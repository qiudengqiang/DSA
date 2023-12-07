package com.alphabethub.array;

/**
 * 找出数组中第二大的值
 */
public class SecondMaxNum {
    public static void main(String[] args) {
        int[] array = {3, 25, 9, 7, 16, 10, 6};
        System.out.println(findSecondMaxNum(array));
    }

    /**
     * 思路：设置两个变量来进行判断。max表示数组中的最大的数，初始值为a[0], second表示第二大的数，初始值为整数的最小值min, 对数组a进行遍历，从1开始，出现两种需要注意的情况：
     * 1.  当前元素 > max： 这时second的值应是max的当前值，并且max的值应是当前元素的值。
     * 2.  second < 当前元素 < max : second 的值为当前元素的值
     *
     * @param nums
     * @return
     */
    public static int findSecondMaxNum(int[] nums) {
        int max = nums[0];
        int second = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return second;
    }
}
