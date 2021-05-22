package com.alphabethub.api.cache.lru;

public class DoubleList {
    //头尾虚拟节点
    private Node head, tail;
    //链表元素数
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 添加节点到尾部，时间复杂度O(1)
     * @param node
     */
    public void addLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    /**
     * 删除节点，时间复杂度O(1)
     * @param node
     */
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    /**
     * 删除链表中第一个节点，时间复杂度O(1)
     * @return
     */
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }

        Node first = head.next;
        remove(first);
        return first;
    }

    /**
     * 返回链表的长度，时间复杂度O(1)
     * @return
     */
    public int size() {
        return size;
    }
}
