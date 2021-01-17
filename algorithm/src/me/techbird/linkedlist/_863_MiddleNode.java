package me.techbird.linkedlist;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _863_MiddleNode {
    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int i = 0;
        for (; head != null; i++) {
            nodes[i] = head;
            head = head.next;
        }
        return nodes[i / 2];
    }

    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     *
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            ++count;
            current = current.next;
        }

        current = head;
        int i = 0;
        while (i < count / 2) {
            ++i;
            current = current.next;
        }
        return current;
    }

    /**
     * 快慢指针法
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     *
     * @param head
     * @return
     */
    public ListNode middleNode3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
