package me.techbird.api.heap;

/**
 * 堆
 *
 * @param <E>
 */
public interface Heap<E> {
    int size();

    boolean isEmpty();

    void clear();

    void add(E element);

    E get();//获取堆顶元素

    E remove();//移除堆顶元素

    E replace(E element);//删除堆顶元素同时插入一个新元素
}
