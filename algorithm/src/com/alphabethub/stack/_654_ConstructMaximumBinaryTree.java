package com.alphabethub.stack;

import java.util.Stack;

/**
 * 654. 最大二叉树
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class _654_ConstructMaximumBinaryTree {

    /**
     * 题目变形：给一个数组，构建一个二叉树，返回二叉树每个节点的父节点指针
     * 思路：利用单调递减栈，push时确定左边第一个最大值，pop时确定右面第一个最大值。
     * 父节点一定是左右里面的最小值
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int[] parentIndexes(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Stack<Integer> stack = new Stack<>();
        //存放左边第一个最大的数
        int[] lis = new int[nums.length];
        //存放右边第一个最大的数
        int[] ris = new int[nums.length];

        //初始化数组的值
        for (int i = 0; i < nums.length; i++) {
            lis[i] = -1;
            ris[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ris[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                lis[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] pis = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (lis[i] == -1 && ris[i] == -1) {
                //i的位置是根节点
                pis[i] = -1;
                continue;
            }

            if (lis[i] == -1) {
                pis[i] = ris[i];
            } else if (ris[i] == -1) {
                pis[i] = lis[i];
            } else {
                pis[i] = Math.min(nums[lis[i]], nums[ris[i]]);
            }
        }

        return pis;
    }

    /**
     * 思路：利用递归，最大值做根节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return findRoot(nums, 0, nums.length);
    }

    private TreeNode findRoot(int[] nums, int l, int r) {
        if (l == r) return null;
        int maxIdx = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = findRoot(nums, l, maxIdx);
        root.right = findRoot(nums, maxIdx + 1, r);
        return root;
    }
}
