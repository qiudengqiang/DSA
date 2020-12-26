package me.techbird.leetcode.tree.bst;

import me.techbird.leetcode.tree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class _450_DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key == root.val) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }else if (key < root.val) {
            root.right = deleteNode(root.right, key);
        }else if (key > root.val) {
            root.left =  deleteNode(root.left, key);
        }
        return root;
    }

    public TreeNode getMin(TreeNode node) {
        while(node.left!= null) node = node.left;
        return node;
    }
}

