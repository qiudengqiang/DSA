package com.alphabethub.string;

import com.alphabethub.tree.TreeNode;

/**
 * 572. 另一棵树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 题意解析：子树的包括根节点在内的所有节点，在大树中存在
 * 思路：序列化为完全二叉树字符串，然后利用contains或者KMP判断是否为包含子串
 */
public class _572_IsSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        return postSerializer(root).contains(postSerializer(subRoot));
    }

    /**
     * 后续序列化
     *
     * @param root
     * @return
     */
    public String postSerializer(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerializer(root, sb);
        return sb.toString();
    }

    public void postSerializer(TreeNode root, StringBuilder sb) {
        if (root.left == null) {
            sb.append("#!");
        } else {
            postSerializer(root.left, sb);
        }
        if (root.right == null) {
            sb.append("#!");
        } else {
            postSerializer(root.right, sb);
        }
        sb.append(root.val).append("!");
    }


    /**
     * 先序序列化的坑：
     * A：12!#!#!
     * B：2!#!#!
     * B是A的子串，但不是A的子树
     * 解决方案：在最前面增加一个特殊符号
     * A：!12!#!#!
     * B：!2!#!#!
     */
    public String preSerializer(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preSerializer(root, sb);
        return sb.toString();
    }

    public void preSerializer(TreeNode root, StringBuilder sb) {
        sb.append(root.val).append("!");
        if (root.left == null) {
            sb.append("#!");
        } else {
            postSerializer(root.left, sb);
        }
        if (root.right == null) {
            sb.append("#!");
        } else {
            postSerializer(root.right, sb);
        }
    }
}
