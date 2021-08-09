package com.alphabethub.linkedlist;

/**
 * leetcode 链表节点定义
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }




    public static ListNode generateFromVals(int[] vals){
        ListNode node = new ListNode(0);
        ListNode cur = node;
        for (int i = 0; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
        return node.next;
    }

}
