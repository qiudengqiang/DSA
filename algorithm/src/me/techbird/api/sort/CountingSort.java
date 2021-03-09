package me.techbird.api.sort;

public class CountingSort extends Sort<Integer> {

    @Override
    protected void sort() {
        //找出最值范围
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        //开辟存储空间，存储次数
        int[] counts = new int[max - min + 1];
        //统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            //-min是为了把元素放置在数组中依次从0开始的角标中
            counts[array[i] - min]++;
        }

        //累加次数：
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        //从后往前遍历元素，将它放到数组中合适的位置
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i] - min]] = array[i];
        }
        //将有序数组赋值到array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }


    /**
     * 原始的计数排序，浪费空间较多
     */
    private void sort0() {
        //找出最值范围
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 开辟内存空间，存储每个整数出现的次数
        int[] counts = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }
        // 根据整数的出现次数，对整数进行排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                array[index++] = i;
            }
        }
    }
}
