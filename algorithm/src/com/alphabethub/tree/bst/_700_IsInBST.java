package com.alphabethub.tree.bst;

import com.alphabethub.tree.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class _700_IsInBST {
    TreeNode node = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (val == root.val) {
            node = root;
        }

        if (val < root.val) {
            root.left = searchBST(root.left, val);
        }
        if (val > root.val) {
            root.right = searchBST(root.right, val);
        }
        return node;
    }
}
