package com.alphabethub.tree.binary;


import com.alphabethub.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class _622_BinaryTreeMaximumWidth {

    class AnnotateNode {
        TreeNode node;
        int pos;

        public AnnotateNode(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

    /**
     * width = right.position-left.position+1
     * left.position = root.position * 2 + 1
     * right.position = root.position * 2 + 2
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<AnnotateNode> queue = new LinkedList<>();
        queue.offer(new AnnotateNode(root, 0));
        int levelSize = 1;
        int width = 0;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            width = Math.max(width, queue.getLast().pos - queue.getFirst().pos + 1);
            while (levelSize > 0) {
                AnnotateNode a = queue.remove();
                if (a.node.left != null) {
                    queue.offer(new AnnotateNode(a.node.left, a.pos * 2 + 1));
                }

                if (a.node.right != null) {
                    queue.offer(new AnnotateNode(a.node.left, a.pos * 2 + 2));
                }
                levelSize--;
            }
        }
        return width;
    }

}
