package com.alphabethub.linkedlist;

/**
 * 234.回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class _234_IsPalindrome {
    /**
     * 最优解：
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //找到中间节点
        ListNode midNode = middleNode(head);
        //反转中间节点的右半部分
        ListNode rHead = reverseList(midNode.next);
        ListNode lHead = head;

//        ListNode rOldHead = rHead;

        while (rHead != null) {
            if (lHead.val != rHead.val) {
                return false;
            }
            lHead = lHead.next;
            rHead = rHead.next;
        }

        //恢复中间节点的右半部分
//        reverseList(rOldHead);

        return true;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
