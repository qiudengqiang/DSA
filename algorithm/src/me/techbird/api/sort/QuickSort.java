package me.techbird.api.sort;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    /**
     * 对[begin,end)范围元素进行快速排序
     *
     * @param begin
     * @param end
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        //确定轴点位置
        int mid = pivotIndex(begin, end);
        //对子序列进行快速排序
        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * 构造出[begin,end)位置元素的轴点位置
     *
     * @param begin
     * @param end
     * @return 轴点元素的最终位置
     */
    private int pivotIndex(int begin, int end) {
        //随机选择一个位置的元素跟begin位置交换，能够降低发生最坏复杂度情况的概率
        swap(begin, begin + (int) (Math.random() * (end - begin)));
        //备份begin位置的元素
        T pivot = array[begin];
        //让end指向最后一个元素
        end--;

        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) {
                    end--;
                } else {//右边元素>=轴点元素
                    array[begin++] = array[end];
                    break;
                }
            }

            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) {
                    begin++;
                } else {//左边元素>=轴点元素
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        //将轴点元素放入最终的位置
        array[begin] = pivot;
        //返回轴点元素的位置
        return begin;
    }
}
