package com.alphabethub.jzoffer;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class _05_QueueImplOfStack {
    Stack<Integer> inStack = new Stack<Integer>();
    Stack<Integer> outStack = new Stack<Integer>();

    public void push(int node) {
        inStack.push(node);
    }

    public int pop() {
        checkStack();
        return outStack.pop();
    }

    private void checkStack(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
}
