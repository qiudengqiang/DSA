package me.techbird.leetcode.linkedlist;

import java.util.List;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _21_MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists2(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode node = new ListNode(0);
        ListNode cur = node;
        while (l1 != null && l2 != null) {
            if (l2.val > l1.val) {
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next  = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            //任一为空直接链接另一条链表
            if(l1 == null){
                cur.next = l2;
            }else{
                cur.next = l1;
            }
        }
        return node.next;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        while (l2 != null && l2.next != null) {
            if (l2.val >= l1.val && l2.val < l1.next.val) {
                ListNode node = new ListNode(l2.val);
                node.next = l1.next;
                l1.next = node;
            }
            l2 = l2.next;
        }

        return l1;
    }
}
