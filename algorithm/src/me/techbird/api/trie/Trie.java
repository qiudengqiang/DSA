package me.techbird.api.trie;

import java.util.HashMap;

public class Trie<V> {
    private int size;
    private Node<V> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public V get(String key) {
        Node<V> node = node(key);
        return node != null && node.word ? node.value : null;
    }

    public boolean contains(String key) {
        Node<V> node = node(key);
        return node != null && node.word;
    }

    public V add(String key, V value) {
        checkKey(key);

        if (root == null) {
            root = new Node<>();
        }
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c = key.charAt(i);
            boolean emptyChildren = node.children == null;
            Node<V> childrenNode = emptyChildren ? null : node.children.get(c);
            if (childrenNode == null) {
                childrenNode = new Node<>();
                node.children = emptyChildren ? new HashMap<>() : node.children;
                node.children.put(c, childrenNode);
            }
            node = childrenNode;
        }

        if (node.word) {//已经存在这个单词
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        node.word = true;
        node.value = value;
        size++;
        return null;
    }

    public V remove(String key) {

    }

    public boolean startsWith(String prefix) {
        return node(prefix) != null;
    }

    private Node<V> node(String key) {
        checkKey(key);
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            if (node == null || node.children == null || node.children.isEmpty()) return null;
            char c = key.charAt(i);
            node = node.children.get(c);
        }
        return node;
    }

    private void checkKey(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("key must be not empty");
        }
    }

    private static class Node<V> {
        HashMap<Character, Node<V>> children;
        V value;
        boolean word;// 是否为单词的结尾（是否为一个完整的单词）
    }
}
