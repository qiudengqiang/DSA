package com.alphabethub.api.cache.lru;


import java.util.LinkedHashMap;

/**
 * 使用LinkedHashMap实现
 */
public class LRUCache2 {
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int cap;

    public LRUCache2(int capacity) {
        this.cap = capacity;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }

        if (cap == cache.size()) {
            Integer deleteKey = cache.keySet().iterator().next();
            cache.remove(deleteKey);
        }

        cache.put(key, value);
    }


    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        makeRecently(key);
        return cache.get(key);
    }

    private void makeRecently(Integer key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

}
