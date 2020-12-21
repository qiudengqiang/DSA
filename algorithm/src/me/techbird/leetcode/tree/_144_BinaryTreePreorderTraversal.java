package me.techbird.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    public void preorder(TreeNode node, List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }
}
