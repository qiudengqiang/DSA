package me.techbird.linkedlist;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_DeleteSortedDuplicatesElements {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel, curr = head;
        while (curr != null && curr.next != null) {
            if(curr.val == curr.next.val){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}
