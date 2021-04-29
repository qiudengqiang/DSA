package com.alphabethub.tree.bst;

import com.alphabethub.api.stack.Stack;
import com.alphabethub.tree.TreeNode;

import java.util.*;

/**
 * 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class _938_RangeSumOfBST {

    int ans = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return ans;
    }

    void inorder(TreeNode root, int L, int R) {
        if (root == null) return;
        inorder(root.left, L, R);
        if (root.val >= L && root.val <= R) {
            ans += root.val;
        }
        inorder(root.right, L, R);
    }

    /**
     * 非递归栈
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST3(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum = 0;
        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();

            if (node != null) {
                if (low <= node.val && node.val <= high) {
                    sum += node.val;
                }

                if (low < node.val) {
                    queue.push(node.left);
                }
                if (node.val < high) {
                    queue.push(node.right);
                }
            }

        }
        return sum;
    }

    /**
     * 非递归队列
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                if (low <= node.val && node.val <= high) {
                    sum += node.val;
                }

                if (low < node.val) {
                    queue.offer(node.left);
                }
                if (node.val < high) {
                    queue.offer(node.right);
                }
            }

        }
        return sum;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > low) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


}
