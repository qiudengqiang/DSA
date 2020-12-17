package me.techbird.leetcode.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_InvertBinaryTree {
    /**
     * 先序
     *
     * @param root
     * @return
     */
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//
//        invertTree(root.right);
//        invertTree(root.left);
//        return root;
//    }

    /**
     * 中序
     * 需要注意中序遍历递归的是同一侧，因为存在先交换的问题
     * @param root
     * @return
     */
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//        invertTree(root.right);
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        invertTree(root.right);
//        return root;
//    }

    /**
     * 后序
     *
     * @param root
     * @return
     */
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//        invertTree(root.right);
//        invertTree(root.left);
//
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        return root;
//    }

    /**
     * 层次
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }
}
