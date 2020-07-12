package me.techbird.leetcode.linkedlist;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _863_MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int i = 0;
        for (; head != null; i++) {
            nodes[i] = head;
            head = head.next;
        }
        ListNode middle = nodes[i/2];
        return middle;
    }
}
