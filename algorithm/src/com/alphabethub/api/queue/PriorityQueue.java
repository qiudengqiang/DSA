package com.alphabethub.api.queue;

import com.alphabethub.api.heap.BinaryHeap;

import java.util.Comparator;

/**
 * 优先级队列
 *
 * @param <E>
 */
public class PriorityQueue<E> {
    private BinaryHeap<E> heap;
    private Comparator<E> comparator;

    public PriorityQueue() {
        this(null);
    }

    public PriorityQueue(Comparator<E> comparator) {
        heap = new BinaryHeap<>(comparator);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void clear() {
        heap.clear();
    }

    public void enQueue(E e) {
        heap.add(e);
    }

    public E deQueue() {
        return heap.remove();
    }

    public E front() {
        return heap.get();
    }
}
