package me.techbird.leetcode.api.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * 双端队列(double ended queue)
 */
public class Deque<E> {
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void enQueueFront(E e) {
        list.add(0, e);
    }

    public void enQueueRear(E e) {
        list.add(e);
    }

    public E deQueueFront() {
        return list.remove(0);
    }

    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    public E front() {
        return list.get(0);
    }

    public E rear() {
        return list.get(list.size() - 1);
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
