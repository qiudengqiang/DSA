package com.alphabethub.exam.tencent.one;

public class First {
    public static void main(String[] args) {
    }

    public ListNode[] solve(int m, ListNode a) {
        ListNode[] nodes = new ListNode[m];
        ListNode[] tails = new ListNode[m];
        while (a != null) {
            ListNode node = nodes[a.val % m];
            if (node == null) {
                nodes[a.val % m] = new ListNode(a.val);
                tails[a.val % m] =  nodes[a.val % m];
            } else {
                tails[a.val%m].next = new ListNode(a.val);
                tails[a.val%m] = tails[a.val%m].next;
            }
            a = a.next;
        }
        return nodes;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
