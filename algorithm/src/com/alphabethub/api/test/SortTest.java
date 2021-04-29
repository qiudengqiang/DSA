package com.alphabethub.api.test;

import com.alphabethub.api.sort.BucketSort;
import com.alphabethub.api.sort.CountingSort;
import com.alphabethub.api.sort.RadixSort;
import com.alphabethub.api.sort.Sort;
import com.alphabethub.api.sort.cmp.MergeSort;
import com.alphabethub.tool.Asserts;
import com.alphabethub.tool.Integers;
import me.techbird.api.sort.*;
import com.alphabethub.api.sort.cmp.HeapSort;
import com.alphabethub.api.sort.cmp.QuickSort;

import java.util.Arrays;

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
