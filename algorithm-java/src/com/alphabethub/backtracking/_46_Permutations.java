package com.alphabethub.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class _46_Permutations {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //contains的时间复杂度是O(n)，可以针对其进行优化
            if (track.contains(nums[i])) continue;

            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
