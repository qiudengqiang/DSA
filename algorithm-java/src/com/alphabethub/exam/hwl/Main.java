package com.alphabethub.exam.hwl;

import com.alphabethub.linkedlist.ListNode;

public class Main {
    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                tail.next = head2;
                head2 = head2.next;
            } else {
                tail.next = head1;
                head1 = head1.next;
            }
            tail = tail.next;
        }
        tail.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}
