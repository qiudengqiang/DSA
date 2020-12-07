package me.techbird.leetcode.linkedlist;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int t = 0;
        ListNode cur = head;
        while (cur != null) {
            ++t;
            cur = cur.next;
        }
        if (t == 1 && n == 1) return null;
        if (t == n) return head.next;

        cur = head;
        for (int i = 0; i < t - n - 1; i++) {
            cur = cur.next;
        }
        if (cur.next != null)
            cur.next = cur.next.next;

        return head;
    }

    /**
     * 在方法一的基础上增加「哨兵」节点，以简化代码
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        int len = getLength(head);
        ListNode cur = sentinel;
        for (int i = 1; i < len - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return sentinel.next;
    }

    public static int getLength(ListNode head) {
        int t = 0;
        ListNode cur = head;
        while (cur != null) {
            ++t;
            cur = cur.next;
        }
        return t;
    }

}
