package com.alphabethub.jzoffer;

public class _06_MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            if (nums[low] < nums[high]) {//子数组是非递减数组:10111
                return nums[low];
            }
            mid = low + ((high - low) >> 1);
            if (nums[mid] > nums[low]) {//最小值处于递增,low上移
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {//最小值处于递减，high下移
                high = mid;
            }else{//其余情况，low++缩小范围
                low++;
            }
        }
        return nums[low];
    }
}
