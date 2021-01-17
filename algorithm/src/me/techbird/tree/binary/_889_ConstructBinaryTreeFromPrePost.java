package me.techbird.tree.binary;

import me.techbird.tree.TreeNode;

import java.util.Arrays;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class _889_ConstructBinaryTreeFromPrePost {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) return root;

        for (int i = 0; i < post.length; i++) {
            if (pre[1] == post[i]) {
                int leftCount = i + 1;

                int[] pre_left = Arrays.copyOfRange(pre, 1, leftCount + 1);
                int[] pre_right = Arrays.copyOfRange(pre, leftCount + 1, pre.length);
                int[] post_left = Arrays.copyOfRange(post, 0, leftCount);
                int[] post_right = Arrays.copyOfRange(post, leftCount, pre.length - 1);

                root.left = constructFromPrePost(pre_left, post_left);
                root.right = constructFromPrePost(pre_right, post_right);
                break;
            }
        }
        return root;
    }

}
