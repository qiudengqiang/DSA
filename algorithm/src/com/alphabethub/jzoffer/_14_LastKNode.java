package com.alphabethub.jzoffer;

import com.alphabethub.linkedlist.ListNode;

public class _14_LastKNode {
    public ListNode findKthToTail(ListNode pHead, int k) {
        if (pHead == null) return null;
        ListNode slow = pHead, fast = pHead;
        int len = 0;
        while (fast != null && len < k) {
            fast = fast.next;
            len++;
        }
        if (len < k) return null;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
