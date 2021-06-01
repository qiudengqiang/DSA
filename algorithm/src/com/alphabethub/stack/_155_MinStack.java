package com.alphabethub.stack;

import java.util.Stack;

/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 */
public class _155_MinStack {




    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public _155_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        }else{
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
