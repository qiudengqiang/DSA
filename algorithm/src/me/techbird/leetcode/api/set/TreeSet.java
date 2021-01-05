package me.techbird.leetcode.api.set;

import me.techbird.leetcode.api.tree.BinaryTree;
import me.techbird.leetcode.api.tree.RBTree;

public class TreeSet<E> implements Set<E> {
    private RBTree<E> rbTree = new RBTree<>();

    @Override
    public int size() {
        return rbTree.size();
    }

    @Override
    public boolean isEmpty() {
        return rbTree.isEmpty();
    }

    @Override
    public void clear() {
        rbTree.clear();
    }

    @Override
    public boolean contains(E element) {
        return rbTree.contains(element);
    }

    @Override
    public void add(E element) {
        rbTree.add(element);
    }

    @Override
    public void remove(E element) {
        rbTree.remove(element);
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        if (visitor == null) return;
        rbTree.inorderTraversal(new BinaryTree.Visitor<E>() {
            @Override
            public boolean visit(E element) {
                return visitor.visit(element);
            }
        });
    }
}
