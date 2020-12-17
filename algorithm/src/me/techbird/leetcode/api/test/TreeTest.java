package me.techbird.leetcode.api.test;

import me.techbird.leetcode.api.tree.BinarySearchTree;
import me.techbird.leetcode.tool.printer.BinaryTrees;

public class TreeTest {
    public static void main(String[] args) {

        test();

    }

    static void test() {
        Integer[] data = new Integer[]{
                7, 4, 2, 1, 3, 5, 9, 8, 11, 10, 12
        };

        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);

        bst.inorderTraversal(new BinarySearchTree.Visitor<Integer>() {

            @Override
            public boolean visit(Integer element) {
//                System.out.print(element+ " ");
                return false;
            }
        });

//        System.out.println(bst.height());
//        System.out.println(bst.isComplete());
        bst.remove(1);
        bst.remove(11);
        BinaryTrees.println(bst);
    }
}
