package me.techbird.api.test;

import me.techbird.api.sort.*;
import me.techbird.tool.Asserts;
import me.techbird.tool.Integers;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Integer[] array = Integers.random(50000, 1, 50000);
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
                new ShellSort(),
                new HeapSort()
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
