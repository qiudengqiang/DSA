package me.techbird.leetcode.zzz.list;


public class ArrayList<E> extends AbstractList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        //进行缩容操作
        if(elements!=null && elements.length > DEFAULT_CAPACITY){
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        //检查角标
        rangeCheckForAdd(index);
        //检查容量
        ensureCapacity(size + 1);
        //移动指定位置后面的数据
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        //新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "扩容为：" + newCapacity);
    }

    public void trim(){
        int oldCapacity = elements.length;
        //缩容一半
        int newCapacity = oldCapacity >> 1;
        if(size >= newCapacity || oldCapacity < DEFAULT_CAPACITY) return;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "缩容为：" + newCapacity);
    }

    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        //把指定位置后面的数据向前移动
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        trim();
        return old;
    }


    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public int indexOf(E element) {
        //可以做null的索引
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element)) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(",");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
