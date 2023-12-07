package com.alphabethub.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class _39_CombinationSum {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(0, candidates, target, track);
        return res;
    }

    void backtrack(int depth, int[] nums, int target, LinkedList<Integer> track) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = depth; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(i, nums, target - nums[i], track);
            track.removeLast();
        }
    }
}
