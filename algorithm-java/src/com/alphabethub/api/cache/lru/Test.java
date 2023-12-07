package com.alphabethub.api.cache.lru;

import com.alphabethub.tool.Asserts;

public class Test {
    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);

        cache.put(1, 1);
        cache.put(2, 2);
        Asserts.test(cache.get(1) == 1);
        cache.put(3, 3);
        Asserts.test(cache.get(2) == -1);
        cache.put(1, 4);
        Asserts.test(cache.get(1) == 4);
    }
}
