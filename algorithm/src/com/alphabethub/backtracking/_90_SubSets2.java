package com.alphabethub.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90.子集2
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class _90_SubSets2 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, 0, track,used);
        return res;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track,boolean[] used) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            if(used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) continue;

            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, i + 1, track,used);
            used[i] = false;
            track.removeLast();
        }
    }
}
