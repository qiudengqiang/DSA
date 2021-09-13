package com.alphabethub.exam.tencent.two;

import java.util.LinkedList;
import java.util.Queue;

public class First {
    public ListNode solve(ListNode[] a) {
        if(a == null || a.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        Queue<ListNode> queue = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                queue.offer(a[i]);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
