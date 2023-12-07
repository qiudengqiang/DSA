package com.alphabethub.array;


import java.util.HashMap;

/**
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 */
public class _136_SingleNumber {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && map.get(nums[i]) == 1) return nums[i];
        }
        return -1;
    }

    /**
     * 使用异或运算。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


}
