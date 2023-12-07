package com.alphabethub.linkedlist;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _863_MiddleNode {

    public static void main(String[] args) {
        ListNode head = ListNode.generateFromVals(new int[]{1, 1, 2, 1});
        System.out.println(middleNode(head).val);
        System.out.println(middleNode2(head).val);
    }



    /**
     * 双指针技巧
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 与上面方法区别是什么？
     * 1.奇数节点情况下：返回值一样都是中间节点
     * 2.偶数节点情况下：上面方法返回中间的右边节点，本方法返回中间的左边节点
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
