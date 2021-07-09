package com.alphabethub.stack;

import java.util.Stack;

/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 */
public class _155_MinStack {
    /**
     * 算法思路：利用两个栈实现：一个正常栈，一个最小栈; 每次存放元素时候，最小栈都保存当前的最小值
     * 利用空间换时间
     * 时间复杂度：O(1)
     * 空间复杂度：O(n)
     */
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
