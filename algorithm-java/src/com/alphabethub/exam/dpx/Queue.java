package com.alphabethub.exam.dpx;

/**
 * 使用数组完成一个队列的基本操作
 */
public class Queue<T> {
    private int capacity = 10;
    private T[] queue;
    private int size = 0;

    public Queue(int capacity) {
        if (capacity < 10) {
            capacity = 10;
        }
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    public void push(T value) {
        if (size == capacity) return;
        queue[size] = value;
        size++;
    }

    public T pop() {
        if (size == 0) return null;
        T top = queue[0];
        for (int i = 0; i < size; i++) {
            queue[i] = queue[i + 1];
        }
        size--;
        return top;
    }

    public T top() {
        if (size == 0) return null;
        return queue[0];
    }
}
