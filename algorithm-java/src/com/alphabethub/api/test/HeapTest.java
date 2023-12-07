package com.alphabethub.api.test;

import com.alphabethub.tool.printer.BinaryTrees;
import com.alphabethub.api.heap.BinaryHeap;

import java.util.Comparator;

public class HeapTest {
    public static void main(String[] args) {
        topk();
    }

    static void topk() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //构建小顶堆
                return o2 - o1;
            }
        });

        Integer[] data = {60, 47, 83, 5, 93, 19, 63, 51, 77, 84, 10, 6, 32, 25, 62, 3, 96, 8, 55, 44};

        //前三个最大
        int k = 3;
        for (int i = 0; i < data.length; i++) {//O(n)
            if (heap.size() < k) {
                heap.add(data[i]);//O(logk)
            } else if (data[i] > heap.get()) {
                heap.replace(data[i]);//O(logk)
            }
        }

        BinaryTrees.println(heap);

    }

    static void test3() {
        Integer[] data = {60, 47, 83, 5, 93, 19, 63, 51, 77, 84, 10, 6, 32, 25, 62, 3, 96, 8, 55, 44};

        BinaryHeap<Integer> heap = new BinaryHeap<>(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //构建小顶堆
                return o2 - o1;
            }
        });
        BinaryTrees.println(heap);

    }

    static void test2() {
        Integer[] data = {60, 47, 83, 5, 93, 19, 63, 51, 77, 84, 10, 6, 32, 25, 62, 3, 96, 8, 55, 44};

        BinaryHeap<Integer> heap = new BinaryHeap<>(data);
        BinaryTrees.println(heap);

    }

    static void test1() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(68);
        heap.add(72);
        heap.add(43);
        heap.add(50);
        heap.add(38);
        heap.add(10);
        heap.add(90);
        heap.add(65);
        BinaryTrees.println(heap);
//        heap.remove();
//        BinaryTrees.println(heap);
        heap.replace(70);
        BinaryTrees.println(heap);
    }

}
