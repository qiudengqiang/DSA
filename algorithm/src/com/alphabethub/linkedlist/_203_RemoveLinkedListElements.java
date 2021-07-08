package com.alphabethub.linkedlist;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_RemoveLinkedListElements {

    /**
     * 思路：新建一个链表，把不等于val的节点串在新链表的尾部
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head != null) {
            if (head.val != val) {
                tail.next = head;
                tail = head;
            }
            head = head.next;
        }
        //这一句比较关键
        tail.next = null;
        return dummy.next;
    }
}