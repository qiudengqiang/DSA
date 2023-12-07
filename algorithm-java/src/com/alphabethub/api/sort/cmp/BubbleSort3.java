package com.alphabethub.api.sort.cmp;

import com.alphabethub.api.sort.Sort;

/**
 * 对数据局部有序（eg: 尾部）情况做优化的冒泡排序
 */
public class BubbleSort3 extends Sort {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }
}
