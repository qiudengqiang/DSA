package com.alphabethub.jzoffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 * 限制：
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _53_SearchByteRepeatCount {
    /**
     * 方法一：遍历数组与target作比较，设置计数器
     * 算法时间复杂度：o(n)
     */
    public int search1(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * TODO 方法二：利用二分查找
     * 时间复杂度：O(log2n)
     */
    public int search2(int[] nums, int target) {
        return 0;
    }
}
