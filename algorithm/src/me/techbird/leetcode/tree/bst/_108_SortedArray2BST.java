package me.techbird.leetcode.tree.bst;

import jdk.nashorn.internal.objects.NativeJava;
import me.techbird.leetcode.tree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class _108_SortedArray2BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArray2BST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArray2BST(int[] nums, int left, int right) {
        if (left > right) return null;
        //总是用中间节点的左边作为根节点
        int mid = (left+right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArray2BST(nums, left, mid - 1);
        root.right = sortedArray2BST(nums, mid + 1, right);
        return root;
    }
}
