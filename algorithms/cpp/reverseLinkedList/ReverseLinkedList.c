//
//  ReverseList.c
//  Exam
//
//  Created by techbird on 2019/1/24.
//  Copyright © 2019 apple. All rights reserved.
//

#include <stdio.h>

/**
 反转一个单链表。
 
 示例:
 
 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 */

typedef struct ListNode {
    int val;
    struct ListNode *next;
}ListNode;

struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode *h = NULL,*p = NULL;
    while (head){
        p = head->next;
        head->next = h;
        h = head;
        head = p;
    }
    return h;
}
