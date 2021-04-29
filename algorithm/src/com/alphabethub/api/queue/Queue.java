package com.alphabethub.api.queue;

import com.alphabethub.api.list.DoubleLinkedList;
import com.alphabethub.api.list.List;

public class Queue<E> {
    private List<E> list = new DoubleLinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void enQueue(E e) {
        list.add(e);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size()).append("[");
        for (int i = 0; i < size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(list.get(i));
        }
        sb.append("]");
        return sb.toString();
    }
}
