package me.techbird.leetcode.tree.bst;

import me.techbird.leetcode.tree.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 */
public class _783_MinestDistanceBetweenNode {
    int ans,pre;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(pre == -1){
            pre = root.val;
        }else{
            ans = Math.min(ans, root.val-pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
