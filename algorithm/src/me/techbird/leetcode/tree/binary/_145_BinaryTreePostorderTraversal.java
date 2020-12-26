package me.techbird.leetcode.tree.binary;

import me.techbird.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(TreeNode node, List<Integer> list){
        if(node == null) return;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }
}
