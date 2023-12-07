package com.alphabethub.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47.全排列2
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class _47_Permutations2 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // if(track.contains(nums[i])) continue;
            if (used[i]) continue;
            //使用used[i-1]，可以不取反，结果仍然正确
            //为什么？参考 https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            used[i] = false;
            track.removeLast();
        }
    }
}
