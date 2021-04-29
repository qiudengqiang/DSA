package com.alphabethub.linkedlist;

/**
 * 206.反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_ReverseSinglyLinkedList {
    /**
     * 递归方式
     * 思路需要画图
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        //reverseList(head.next)可以得到出head以外的反转,例如reverseList(4)得到:1->2->3->4
        ListNode newHead = reverseList(head.next);
        //最后处理第一个head的拼接问题，4的指针仍然由5的next指向，所以逆置一下4和5两者的关系
        head.next.next = head;
        head.next = null;
        //返回新的head
        return newHead;
    }

    /**
     * 非递归方式1
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            //下面这一步非常关键
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

}
