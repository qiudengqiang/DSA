package com.alphabethub.jzoffer;

import com.alphabethub.linkedlist.ListNode;

/**
 * JZ36 两个链表的第一个公共结点
 */
public class _36_FirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = l1 == null ? pHead2 : l1.next;
            l2 = l2 == null ? pHead1 : l2.next;
        }
        return l1;
    }
}

