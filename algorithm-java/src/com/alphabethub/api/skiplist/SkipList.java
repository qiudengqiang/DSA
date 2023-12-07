package com.alphabethub.api.skiplist;

import java.util.Comparator;

/**
 * 跳表
 */
public class SkipList<K, V> {
    private int MAX_LEVEL = 32;
    private double P = 0.25;
    private int size;
    private Comparator<K> comparator;

    /**
     * 有效层数
     */
    private int level;
    /**
     * 头结点，不存放任何K-V
     */
    private Node<K, V> first;

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        first = new Node<>(null, null, MAX_LEVEL);
    }

    public SkipList() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        keyCheck(key);
        Node<K, V> node = first;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }

            if (cmp == 0) return node.nexts[i].value;
        }
        return null;
    }


    public V put(K key, V value) {
        keyCheck(key);
        Node<K, V> node = first;
        Node<K, V>[] prevs = new Node[level];
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            if (cmp == 0) {//节点存在，直接用新值覆盖旧值
                V oldV = node.nexts[i].value;
                node.nexts[i].value = value;
                return oldV;
            }
            prevs[i] = node;
        }

        //新节点的层数
        int newLevel = randomLevel();
        //添加新节点
        Node<K, V> newNode = new Node<>(key, value, newLevel);
        //设置前驱和后继
        for (int i = 0; i < newLevel; i++) {
            if (i >= level) {
                first.nexts[i] = newNode;
            } else {
                newNode.nexts[i] = prevs[i].nexts[i];
                prevs[i].nexts[i] = newNode;
            }
        }
        //节点数量增加
        size++;
        //计算跳表的最终层数
        level = Math.max(level, newLevel);

        return null;
    }

    private int randomLevel() {
        int level = 1;//最少一层
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public V remove(K key) {
        keyCheck(key);
        Node<K, V> node = first;
        Node<K, V>[] prevs = new Node[level];
        boolean exist = false;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            prevs[i] = node;
            if (cmp == 0) exist = true;
        }

        if (!exist) return null;

        //需要被删除的节点
        Node<K, V> removedMode = node.nexts[0];

        size--;

        //设置后继
        for (int i = 0; i < removedMode.nexts.length; i++) {
            prevs[i].nexts[i] = removedMode.nexts[i];
        }

        //更新头结点跳表的层数
        int newLevel = level;
        while (--newLevel >= 0 && first.nexts[newLevel] == null) {
            level = newLevel;
        }

        return removedMode.value;
    }

    private int compare(K k1, K k2) {
        return comparator != null ? comparator.compare(k1, k2) : ((Comparable<K>) k1).compareTo(k2);
    }

    private void keyCheck(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null.");
        }
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V>[] nexts;

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            this.nexts = new Node[level];
        }
    }
}
