package com.alphabethub.exam.tencent.two;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(n);
        divide(list);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(i>=l-1 && i<=r-1 && list.get(i) == 1){
                count++;
            }
        }
        System.out.println(count);
        System.out.println(list);
    }


    public static void divide(List<Integer> list) {
        if (!hasMoreThan1(list)) return;
        //首付有大于1的数字
        for (int i = 0; i < list.size(); i++) {
            Integer val = list.get(i);
            if (val > 1) {
                int i1 = val / 2;
                int i2 = val % 2;
                list.addAll(i, Arrays.asList(i1, i2, i1));
                list.remove(val);
                divide(list);
            }
        }
    }

    public static boolean hasMoreThan1(List<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (list.get(i) > 1) {
                return true;
            }
        }
        return false;
    }
}
