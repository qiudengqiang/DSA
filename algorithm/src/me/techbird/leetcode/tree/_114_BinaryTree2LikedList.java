package me.techbird.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_BinaryTree2LikedList {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        int size = list.size();
        for(int i = 1; i<size;++i){
            TreeNode prev = list.get(i-1);
            TreeNode curv = list.get(i);
            prev.left = null;
            prev.right = curv;
        }
    }

    public void inorder(TreeNode node, List<TreeNode> list){
        if(node == null) return;
        list.add(node);
        inorder(node.left, list);
        inorder(node.right, list);
    }
}
