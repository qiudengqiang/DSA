package me.techbird.leetcode.tree.bst;

import me.techbird.leetcode.tree.TreeNode;

/**
 * 99. 恢复二叉搜索树,要求空间复杂度O(1)
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class _99_RecoverBST {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (firstNode == null && preNode.val > root.val) firstNode = preNode;
        if (firstNode != null && preNode.val > root.val) secondNode = root;
        preNode = root;
        inorder(root.right);
    }
}
