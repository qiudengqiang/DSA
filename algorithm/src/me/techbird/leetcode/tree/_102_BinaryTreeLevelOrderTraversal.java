package me.techbird.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class _102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        tree.left = left;
        TreeNode right = new TreeNode(20);
        tree.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        List<List<Integer>> lis = levelOrder(tree);
        System.out.println(lis);

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        int levelSize = 1;
        while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            levelList.add(node.val);
            levelSize--;

            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }
            if(levelSize == 0){
                list.add(levelList);
                levelList = new ArrayList<>();
                levelSize = queue.size();
            }
        }
        return list;
    }

}
