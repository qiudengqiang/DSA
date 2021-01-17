package me.techbird.tree.bst;

import me.techbird.tree.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class _701_InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        //如果已存在，则不重复插入，直接返回
        if (val == root.val) {
            return root;
        }
        //val小，则应该插入到左子树上面
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        //val大，则应该插入到右子树上面
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
