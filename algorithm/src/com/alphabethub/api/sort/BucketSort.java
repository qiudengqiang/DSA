package com.alphabethub.api.sort;

import java.util.LinkedList;
import java.util.List;

/**
 * 桶排序：参考哈希表设计
 * @param <T>
 */
public class BucketSort<T extends Comparable<T>> extends Sort<T> {
    private static final int DEFAULT_CAPACITY =  1 << 4;

    @Override
    protected void sort() {
        List<T>[] buckets = new List[DEFAULT_CAPACITY];
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = index(array[i]);
            List<T> bucket = buckets[bucketIndex];
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[bucketIndex] = bucket;
            }
            bucket.add(array[i]);
        }

        //对每个桶进行排序,再放置回原来的数组
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            buckets[i].sort(null);
            for (T v : buckets[i]) {
                array[index++] = v;
            }
        }

        //TODO 对每个桶排序后直接添加到数组中，不能保证所有元素是升序的
    }

    private int index(T key) {
        return hash(key) & (DEFAULT_CAPACITY - 1);
    }

    private int hash(T key) {
        if (key == null) return 0;
        int hash = key.hashCode();
        return hash ^ (hash >>> 16);
    }
}
