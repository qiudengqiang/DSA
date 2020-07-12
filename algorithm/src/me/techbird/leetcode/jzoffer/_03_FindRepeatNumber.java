package me.techbird.leetcode.jzoffer;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 */
public class _03_FindRepeatNumber {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber1(nums));
    }

    /**
     * 思路一：利用map集合记录出现过的数字，以数字本身为键，当这个数字第二次出现的时候，键自然不为空，直接返回键所对应的值即可。
     * 耗时17ms;
     * 时间复杂度：best:O(1)；worst:O(n^2)：因为hashmap的get方法是for遍历取值； average:0(n)
     */
    public static int findRepeatNumber1(int[] nums) {
        int num = -1;
        Map<String, Integer> repeat = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (repeat.get(String.valueOf(nums[i])) != null) {
                return repeat.get(String.valueOf(nums[i]));
            } else {
                repeat.put(String.valueOf(nums[i]), nums[i]);
            }
        }
        return num;
    }

    /**
     * 利用单列集合HashSet,保证不会存储重复元素
     * 耗时10ms;
     * 时间复杂度：O(n)
     * 遍历数组一遍。使用哈希集合（HashSet），添加元素的时间复杂度为 O(1)，故总的时间复杂度是 O(n)。
     */
    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
