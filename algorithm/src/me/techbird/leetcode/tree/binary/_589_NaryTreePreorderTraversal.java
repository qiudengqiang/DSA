package me.techbird.leetcode.tree.binary;

import me.techbird.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/
 */
public class _589_NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        list.add(root.val);
        preorder(root, list);
        return list;
    }

    public void preorder(Node node, List<Integer> list){
        for(Node n : node.children){
            list.add(n.val);
            preorder(n,list);
        }
    }

}
