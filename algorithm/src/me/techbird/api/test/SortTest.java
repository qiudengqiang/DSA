package me.techbird.api.test;

import me.techbird.api.sort.*;
import me.techbird.api.sort.cmp.HeapSort;
import me.techbird.api.sort.cmp.MergeSort;
import me.techbird.api.sort.cmp.QuickSort;
import me.techbird.api.sort.cmp.ShellSort;
import me.techbird.tool.Asserts;
import me.techbird.tool.Integers;

import java.util.Arrays;
import java.util.HashMap;

public class SortTest {
    public static void main(String[] args) {
        Integer[] array = Integers.random(10000, 1, 20000);
        testSorts(array,

                new QuickSort(),
                new MergeSort(),
//                new BubbleSort1(),
//                new BubbleSort2(),
//                new InsertionSort1(),
//                new InsertionSort2(),
//                new InsertionSort3(),
//                new BubbleSort3(),
//                new SelectionSort(),
//                new ShellSort(),
                new HeapSort(),
                new CountingSort(),
                new RadixSort(),
                new BucketSort()
        );
    }

    static void testSorts(Integer[] array, Sort... sorts){
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort.toString());
        }
    }
}
