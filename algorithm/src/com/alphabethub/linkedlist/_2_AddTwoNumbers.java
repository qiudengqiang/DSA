package com.alphabethub.linkedlist;

/**
 * 2.两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */

public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = l1.val + l2.val + carry;
            if(head == null){
                head = tail = new ListNode(sum%10);
            }else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry>0) tail.next = new ListNode(carry);
        return head;
    }
}
