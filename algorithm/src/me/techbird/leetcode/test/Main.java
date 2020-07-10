package me.techbird.leetcode.test;

import me.techbird.leetcode.practice.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("aa", 11));
        for (int i = 0; i < 20; i++) {
            list.add(new Person("a"+i, i));
            System.out.println(list);
        }
    }
}
