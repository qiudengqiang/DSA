package me.techbird.leetcode.api.tree;

import me.techbird.leetcode.tool.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> implements BinaryTreeInfo {

    protected int size;
    protected Node<E> root;

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public void preorderTraversal(Visitor<E> visitor) {
        if (visitor == null || visitor.stop) return;
        preorderTraversal(root, visitor);
    }

    private void preorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null) return;
        visitor.stop = visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }

    public void inorderTraversal(Visitor<E> visitor) {
        if (visitor == null || visitor.stop) return;
        inorderTraversal(root, visitor);
    }

    private void inorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null) return;

        inorderTraversal(node.left, visitor);
        visitor.stop = visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    public void postorderTraversal(Visitor<E> visitor) {
        if (visitor == null || visitor.stop) return;
        postorderTraversal(root, visitor);
    }

    private void postorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null) return;

        postorderTraversal(node.left, visitor);
        postorderTraversal(node.right, visitor);
        visitor.stop = visitor.visit(node.element);
    }

    public void levelOrderTraversal(Visitor<E> visitor) {

        if (root == null || visitor == null || visitor.stop) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();

            if (visitor.visit(node.element)) return;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public boolean isComplete() {
        if (root == null) return false;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();

            //如果已经出现了一个叶子节点，之后就都必须是叶子节点，否则不是完全二叉树
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {//node.left == null && node.right != null
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {//node.left == null && node.right == null
                leaf = true;
            }
        }
        return true;
    }


    /**
     * 非递归求树的高度
     *
     * @return
     */
    public int height() {
        if (root == null) return 0;
        int height = 0;
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelSize == 0) {//意味着要访问下一层
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 递归求树的高度
     *
     * @return
     */
    public int height2() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * 寻找前驱节点
     *
     * @param node
     * @return
     */
    protected Node<E> predecessor(Node<E> node) {
        if (node == null) return null;

        //前驱在左子树当中(left.right.right.right...)
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        //从父节点、祖父节点当中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        //node.parent == null
        //node == node.parent.right
        return node.parent;
    }

    /**
     * 寻找后继节点
     *
     * @param node
     * @return
     */
    protected Node<E> successor(Node<E> node) {
        if (node == null) return null;

        //前驱在左子树当中(left.right.right.right...)
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        //从父节点、祖父节点当中寻找前驱节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        //node.parent == null
        //node == node.parent.left
        return node.parent;
    }

    protected void checkNotNullElement(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element not be null");
        }
    }

    public static abstract class Visitor<E> {
        boolean stop;

        /**
         * 如果返回true，就代表停止遍历
         *
         * @param element
         * @return
         */
        public abstract boolean visit(E element);
    }

    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return this.right == null && this.left == null;
        }

        public boolean hasTwoChild() {
            return this.left != null && this.right != null;
        }
    }


    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> p = (Node<E>) node;
        String parentString = "null";
        if (p.parent != null) {
            parentString = p.parent.element.toString();
        }
        return p.element + "_p[" + parentString + "]";
    }
}
