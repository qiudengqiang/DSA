package me.techbird.leetcode.tree.binary;

import me.techbird.leetcode.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class _106_ConstructBinaryTreeFromInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap) {

        if (inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.right = buildTree(inorder, inRoot + 1, inEnd, postorder, postStart+numsLeft, postEnd - 1, inMap);
        root.left = buildTree(inorder, inStart, inRoot - 1, postorder, postStart, postStart+numsLeft-1, inMap);

        return root;
    }


}
