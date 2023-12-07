package com.alphabethub.linkedlist;


/**
 * 142. 环形链表 II，环的起点
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class _142_CycleLinkedListBegin {
    public ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
