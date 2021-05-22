package com.alphabethub.api.cache.lru;


import java.util.HashMap;

/**
 * 使用HashMap+自定义双链表实现
 */
public class LRUCache {
    // key -> Node(key,val)
    private HashMap<Integer, Node> map;
    // Node(k1,v1) <-> Node(k2,v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = capacity;
    }

    public int get(Integer key) {
        if (!map.containsKey(key)) return -1;
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(Integer key, Integer value) {
        //如果已经存在直接删除重新添加
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (cap == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    /**
     * 将某个key提升为最近使用的
     *
     * @param key
     */
    private void makeRecently(Integer key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    /**
     * 添加最近使用的元素
     *
     * @param key
     * @param value
     */
    private void addRecently(Integer key, Integer value) {
        Node node = new Node(key, value);
        map.put(key, node);
        cache.addLast(node);
    }

    /**
     * 删除某一个key
     *
     * @param key
     */
    private void deleteKey(Integer key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    /**
     * 删除最久未使用的key
     */
    private void removeLeastRecently() {
        Node node = cache.removeFirst();
        int deleteKey = node.key;
        map.remove(deleteKey);
    }

}
