package me.techbird.leetcode.tree.bst;

import me.techbird.leetcode.tree.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class _98_IsValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 给所有节点设置了一个max和min边界，
     * 约束所有左子树值不超过root的值，
     * 约束所有右子树值不小于root的值。
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
