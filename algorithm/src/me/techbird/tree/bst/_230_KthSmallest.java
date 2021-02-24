package me.techbird.tree.bst;

import me.techbird.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class _230_KthSmallest {

    public int kthSmallest2(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k - 1).val;
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }


}
