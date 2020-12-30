package me.techbird.leetcode.api.test;

import me.techbird.leetcode.api.tree.AVLTree;
import me.techbird.leetcode.api.tree.RBTree;
import me.techbird.leetcode.tool.printer.BinaryTrees;

public class TreeTest {
    public static void main(String[] args) {

        test2();
    }

    static void test2() {
        Integer[] data = new Integer[]{
                60, 73, 99, 48, 86, 57, 61, 7, 6, 75
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }

        BinaryTrees.println(rb);

        for (int i = 0; i < data.length; i++) {
            rb.remove(data[i]);
            System.out.println("--------------------------");
            System.out.println("[" + data[i] + "]");
            BinaryTrees.println(rb);

        }


    }

    static void test() {
        Integer[] data = new Integer[]{
                7, 4, 2, 1, 3, 5, 9, 8, 11, 10, 12
        };

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }

        BinaryTrees.println(avl);

        avl.remove(2);
        avl.remove(1);
        BinaryTrees.println(avl);


    }
}
