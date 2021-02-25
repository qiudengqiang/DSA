package me.techbird.api.sort;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    private int heapSize;

    @Override
    protected void sort() {
        heapSize = array.length;
        //使用下滤原地建堆
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }

        while (heapSize > 1) {
            //交换堆顶和尾部元素
            swap(0, --heapSize);
            //对0位置的元素进行siftDown(恢复堆的性质)
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        T element = array[index];
        int half = heapSize >> 1;
        while (index < half) {//index节点必须是非叶子节点
            //默认左边节点跟父节点比
            int childIndex = (index << 1) + 1;
            T child = array[childIndex];

            int rightIndex = childIndex + 1;
            //右子节点比左子节点大
            if (rightIndex < heapSize && cmp(array[rightIndex], child) > 0) {
                child = array[childIndex = rightIndex];
            }

            // 大于等于子节点
            if (cmp(element, child) >= 0) break;

            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }
}
