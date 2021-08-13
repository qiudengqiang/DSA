package com.alphabethub.heap;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class _23_MergeKSortedList {
    /**
     * 解法1：利用最小堆
     * 时间复杂度：O(n*logk)
     * 空间复杂度：O(k)
     **/
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, (o1, o2) -> {
            return o1.val - o2.val;
        });

        for (ListNode node : lists) {
            if (node != null) heap.offer(node);
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) {
                heap.offer(tail.next);//?为什么要做这一步
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
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l2.val > l1.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }


        tail.next = l1 == null ? l2 : l1;
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
