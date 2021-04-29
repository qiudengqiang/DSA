package com.alphabethub.tree.bst;

import com.alphabethub.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class _173_BSTIterator {
    private TreeNode root;
    private List<TreeNode> list;
    private int currentNode;

    public _173_BSTIterator(TreeNode root) {
        this.root = root;
        list = new ArrayList<>();
        //中序初始化树为列表
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        list.add(node);
        inorderTraversal(node.right);
    }

    public int next() {
        int next = list.get(currentNode++).val;
        return next;

    }

    public boolean hasNext() {
        if(currentNode == list.size()) return false;
        return list.get(currentNode) != null;
    }
}
