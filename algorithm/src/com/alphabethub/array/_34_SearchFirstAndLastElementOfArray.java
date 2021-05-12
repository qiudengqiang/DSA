package com.alphabethub.array;

public class _34_SearchFirstAndLastElementOfArray {


    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = new _34_SearchFirstAndLastElementOfArray().searchRange(nums, 6);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int left = searchRange(nums, target, true);
        int right = searchRange(nums, target, false);

        //left<=right中的'='是关键判断
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    int searchRange(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                if (lower) {
                    right = mid;//别返回，继续缩小边界
                } else {
                    left = mid + 1;
                }
            }
        }
        return lower ? left : left - 1;
    }
}
