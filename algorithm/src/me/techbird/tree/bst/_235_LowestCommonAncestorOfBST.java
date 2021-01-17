package me.techbird.tree.bst;

import me.techbird.tree.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class _235_LowestCommonAncestorOfBST {
    TreeNode ancestor = null;

    /**
     * 利用二叉搜索树的特性
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }
    public void dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root.val < p.val && root.val <q.val ){
           dfs(root.right, p, q);
        }else if(root.val > p.val && root.val >q.val){
           dfs(root.left, p, q);
        }else{
            ancestor = root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left
                , p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }
}
