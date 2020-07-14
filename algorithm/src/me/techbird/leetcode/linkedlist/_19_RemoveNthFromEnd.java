package me.techbird.leetcode.linkedlist;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int t = 0;
        //反转链表删除第n个
        ListNode node = head;
        while (node != null) {
            t++;
            node = node.next;
        }

        if (t == 1 && n == 1) return null;
        if (t == n) return head.next;

        ListNode prev = node(t - n - 1, head);

        if (prev.next != null)
            prev.next = prev.next.next;

        return head;
    }

    public static ListNode node(int index, ListNode head) {
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
