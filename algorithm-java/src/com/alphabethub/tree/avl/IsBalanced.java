package com.alphabethub.tree.avl;

import com.alphabethub.tree.TreeNode;

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (!(Math.abs(balanceFactor(root)) <= 1)) return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int balanceFactor(TreeNode node) {
        return height(node.left) - height(node.right);
    }

    public int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
