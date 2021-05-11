package com.alphabethub.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 78.子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class _78_SubSets {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }
}
