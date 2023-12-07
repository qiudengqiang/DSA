package com.alphabethub.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class _40_CombinationSum2 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        //重点步骤
        Arrays.sort(candidates);
        backtrack(0, candidates, target, track);
        return res;
    }

    void backtrack(int depth, int[] nums, int target, LinkedList<Integer> track) {
        if (target == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        //注意depth
        for (int i = depth; i < nums.length; i++) {
            if (target - nums[i] < 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            track.add(nums[i]);
            //注意i+1
            backtrack(i + 1, nums, target - nums[i], track);
            track.removeLast();
        }
    }
}
