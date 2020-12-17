package me.techbird.leetcode.api.test;

import me.techbird.leetcode.api.stack.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        System.out.println(stack);
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }
}
