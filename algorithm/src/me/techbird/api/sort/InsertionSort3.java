package me.techbird.api.sort;

/**
 * 优化：利用二分查找缩小寻找插入位置的时间为logn，然后一次性搬运数据，再插入到指定位置。
 *
 * @param <T>
 */
public class InsertionSort3<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            insert(begin, search(begin));
        }
    }

    private void insert(int source, int dest) {
        T v = array[source];
        for (int i = source; i > dest; i--) {
            array[i] = array[i-1];
        }
        array[dest] = v;
    }

    /**
     * 利用二分搜索，查找第一个大于array[index]的位置
     * @param index 已经排好序的数组的区间是[0,index)
     * @return
     */
    private int search(int index) {
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = begin + ((end - begin) >> 1);
            if (cmp(array[index], array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
