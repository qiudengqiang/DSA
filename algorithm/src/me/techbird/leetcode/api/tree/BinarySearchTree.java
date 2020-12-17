package me.techbird.leetcode.api.tree;

import me.techbird.leetcode.tool.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索/排序/查找树
 */
public class BinarySearchTree<E> extends BinaryTree {
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        checkNotNullElement(element);
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        Node parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {//相等
                node.element = element;
                return;
            }
        }
        Node<E> newNode = new Node<E>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }


    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (node == null) return;
        size--;

        if (node.hasTwoChild()) {//node是度为2的节点
            // 找到后继节点
            Node<E> s = successor(node);
            //用后继节点分值覆盖度为2的节点的值
            node.element = s.element;
            // 删除后继节点
            node = s;
        }

        // 删除node节点（Node节点的度必为1或者0）
        Node<E> replacement = node.left != null ? node.left : node.right;
        if (replacement != null) {//node是度为1的节点
            replacement.parent = node.parent;

            if (node.parent == null) {//node是度为1的节点并且是根节点
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else {
                node.parent.right = replacement;
            }
        } else if (node.parent == null) {//node是叶子节点并且是根节点
            root = null;
        } else {//node是叶子节点，但不是根节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        }
    }

    public boolean contains(E element) {
        return node(element) != null;
    }


    /**
     * 这个查找节点的方式只针对二叉排序树
     *
     * @param element
     * @return
     */
    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    /**
     * @param e1
     * @param e2
     * @return 返回值等于0代表相等，返回值大于0代表e1大于e2，返回值小于0代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

}
