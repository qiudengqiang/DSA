package com.alphabethub.tree.binary;


import com.alphabethub.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 559. N 叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class _559_NaryTreeMaximumDepth {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int height = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            levelSize--;

            for (Node child : node.children) {
                queue.offer(child);
            }

            if(levelSize == 0){
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }
}
