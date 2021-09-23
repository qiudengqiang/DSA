package com.alphabethub.jzoffer;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class _13_ReOrderArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Arrays.stream(reOrderArray(nums)).forEach(i -> System.out.println(i));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param array
     * @return
     */
    public static int[] reOrderArray(int[] array) {
        if (array == null || array.length == 0) return new int[0];
        int[] nums = new int[array.length];
        int head = 0;
        int tail = array.length - 1;
        int idx_head = head;
        int idx_tail = tail;
        while (head < array.length && tail >= 0) {
            if(array[head]%2 == 1){//奇数放前面
                nums[idx_head] = array[head];
                idx_head++;
            }
            head++;
            if(array[tail]%2 == 0){//偶数放后面
                nums[idx_tail] = array[tail];
                idx_tail--;
            }
            tail--;
        }
        return nums;
    }
}
