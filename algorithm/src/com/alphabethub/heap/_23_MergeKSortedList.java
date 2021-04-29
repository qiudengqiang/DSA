package com.alphabethub.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class _23_MergeKSortedList {
    /**
     * 解法1：利用最小堆
     **/
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) heap.offer(node);
        }

        ListNode head = new ListNode(-1);
        ListNode trail = head;
        while (!heap.isEmpty()) {
            trail.next = heap.poll();
            trail = trail.next;
            if (trail.next != null) {
                heap.offer(trail.next);//?为什么要做这一步
            }
        }
        return head.next;
    }


    /**
     * 解法2：传统方法，循环合并两个链表
     **/
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = merge2List2(ans, lists[i]);
        }
        return ans;
    }


    public ListNode merge2List2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode trail = head;
        while (l1 != null && l2 != null) {
            if (l2.val > l1.val) {
                trail.next = l1;
                l1 = l1.next;
            } else {
                trail.next = l2;
                l2 = l2.next;
            }
            trail = trail.next;
        }


        trail.next = l1 == null ? l2 : l1;
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
