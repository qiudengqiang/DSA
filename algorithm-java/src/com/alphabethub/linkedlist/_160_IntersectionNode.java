package com.alphabethub.linkedlist;

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class _160_IntersectionNode {
    /**
     * 思路：把A链表的尾部接上B链表，在B链表的尾部接上A链表。这样两个链表就等长
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
