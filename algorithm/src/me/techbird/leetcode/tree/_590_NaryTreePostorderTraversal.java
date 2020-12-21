package me.techbird.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class _590_NaryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        list.add(root.val);
        postorder(root, list);
        return list;
    }

    public void postorder(Node node, List<Integer> list){
        for(Node n : node.children){
            postorder(n,list);
            list.add(n.val);
        }
    }
}
