package com.alphabethub.api.sort.cmp;

import com.alphabethub.api.sort.Sort;

/**
 * 优化：先比较寻找位置搬运数据后,再插入。的插入排序
 *
 * @param <T>
 */
public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            T v = array[cur];
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }
    }
}
