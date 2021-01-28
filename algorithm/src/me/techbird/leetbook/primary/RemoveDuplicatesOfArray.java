package me.techbird.leetbook.primary;

/**
 * 删除排序数组中的重复项，返回移除后数组的新长度。
 */
public class RemoveDuplicatesOfArray {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int p = 0;
        for (int i = 1; i < len; i++) {
            if (nums[p] != nums[i]) {
                nums[p + 1] = nums[i];
                p = p + 1;
            }
        }
        return p + 1;
    }
}
