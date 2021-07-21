package com.alphabethub.linkedlist;

/**
 * 86. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 */
public class _86_PartitionList {
    /**
     * 思路：新建两条链表，最后串起来
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode lHead = new ListNode(0);
        ListNode lTail = lHead;
        ListNode rHead = new ListNode(0);
        ListNode rTail = rHead;

        while (head != null) {
            //这里的'='很重要，不然会漏掉元素
            if (head.val >= x) {
                rTail.next = head;
                rTail = head;
            } else {
                lTail.next = head;
                lTail = head;
            }
            head = head.next;
        }
        //这句代码不能少,保证如果最后添加的节点指针不再指向它后面的节点
        rTail.next = null;
        lTail.next = rHead.next;
        return lHead.next;
    }
}
