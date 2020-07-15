package me.techbird.leetcode.test;

import me.techbird.leetcode.practice.ArrayList;
import me.techbird.leetcode.practice.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(0, 10);
        list.add(30);
        list.add(list.size(), 40);
        list.remove(1);
        System.out.println(list);
//        ArrayList<Person> list = new ArrayList<>();
//        list.add(new Person("aa", 11));
//        for (int i = 0; i < 20; i++) {
//            list.add(new Person("a"+i, i));
//            System.out.println(list);
//        }
    }
}
