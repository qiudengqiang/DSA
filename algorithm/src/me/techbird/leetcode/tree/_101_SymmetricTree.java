package me.techbird.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class _101_SymmetricTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        tree.left = left;
        TreeNode right = new TreeNode(2);
        tree.right = right;

        left.left = new TreeNode(3);
        left.right = new TreeNode(5);

        right.left = new TreeNode(4);
        right.right = new TreeNode(3);

        boolean ret = isSymmetric(tree);
        System.out.println(ret);
    }

    /**
     * 递归解法
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 非递归解法
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<String> levelList = new ArrayList<>();
        int levelSize = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelList.add(node == null ? "null" : node.val+"");
            levelSize--;
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (levelSize == 0) {
                if (!isSymmetric(levelList)) {
                    return false;
                }
                levelList = new ArrayList<>();
                levelSize = queue.size();
            }
        }
        return true;
    }

    public static boolean isSymmetric(List<String> list) {
        int len = list.size();
        for (int i = 0; i < len / 2; i++) {
            if (!list.get(i).equals(list.get(len - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
