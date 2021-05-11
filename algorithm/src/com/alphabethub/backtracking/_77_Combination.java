package com.alphabethub.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入两个数字n,k，算法输出[1..n]中k个数字的所有组合
 */
public class _77_Combination {

    public static void main(String[] args) {
        List<List<Integer>> result = new _77_Combination().combination(4, 2);
        System.out.println(result);
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combination(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }
    }
}
