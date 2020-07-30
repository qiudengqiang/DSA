package me.techbird.leetcode.test;

import me.techbird.leetcode.practice.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new Person("a"+i, i));
        }
        for (int i = 0; i < 50; i++) {
            list.remove(0);
        }
        System.out.println(list);
    }
}
