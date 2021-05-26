package com.alphabethub.linkedlist;

/**
 * 2.两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */

public class _2_AddTwoNumbers {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newNode = new ListNode(0);
        ListNode tail = newNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }

            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }

            int sum = v1 + v2 + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        if (carry > 0) tail.next = new ListNode(carry);
        return newNode.next;

    }
}
