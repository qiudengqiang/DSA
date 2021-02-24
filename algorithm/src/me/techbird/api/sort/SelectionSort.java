package me.techbird.api.sort;

public class SelectionSort extends Sort {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            //记录角标
            int max = 0;
            for (int begin = 1; begin <= end; begin++) {
                //注意这里是 <= 为了保证排序的稳定性
                if (cmp(max, begin) <= 0) {
                    max = begin;
                }
            }
            //10 10 8 9
            swap(max, end);
        }
    }
}
