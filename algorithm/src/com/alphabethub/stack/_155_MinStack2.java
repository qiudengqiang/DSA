package com.alphabethub.stack;

/**
 * 使用链表方式实现最小栈更节省空间
 */
public class _155_MinStack2 {
    private Node head;
    /** initialize your data structure here. */
    public _155_MinStack2() {
        head = new Node(0,Integer.MAX_VALUE,null);
    }

    public void push(int val) {
        //头插
        head = new Node(val,Math.min(val,head.min),head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class Node{
        int val;
        int min;
        Node next;
        Node(int val,int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
