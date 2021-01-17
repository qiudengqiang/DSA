package me.techbird.api.queue;

public class CircleQueue<E> {
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        front = 0;
        size = 0;
    }

    public void enQueue(E e) {
        ensureCapacity(size + 1);
        elements[index(size)] = e;
        size++;
    }


    public E deQueue() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    public E front() {
        return elements[front];
    }

    /**
     * 扩容
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        //重置front
        front = 0;
    }

    /**
     * 动态计算循环的索引
     *
     * @param index
     * @return
     */
    private int index(int index) {
        //下面这句代码仍然可以优化
//        return (front + index) % elements.length;

        //已知 n>=0,m>0
        //n%m 等价于 n-(m>n?0:m)的前提条件：n<2m
        index += front;//循环队列不存在负数的情况
        return index - (index < elements.length ? 0 : elements.length);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("capacity=").append(elements.length).append(", size=").append(size);
        sb.append(", front=").append(front).append("[");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
