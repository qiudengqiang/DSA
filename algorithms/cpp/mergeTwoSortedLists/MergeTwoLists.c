//
//  MergeTwoLists.c
//  Exam
//
//  Created by techbird on 2019/1/23.
//  Copyright © 2019 apple. All rights reserved.
//

#include <stdio.h>

/**
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 
 示例：
 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
//单链表节点的定义
struct ListNode {
    int val;
    struct ListNode *next;
}ListNode;

//一次比较两个链表的值，把较小的所在节点值插入到新的链表，利用尾插法
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    
    struct ListNode *head = (struct ListNode*)malloc(sizeof(struct ListNode));
    //s始终指向当前链表的终端节点
    struct ListNode *s = head;
    while (l1!=NULL && l2!=NULL ){
        if(l1->val <= l2->val){
            s->next = l1;
            l1 = l1->next;
        }else{
            s->next = l2;
            l2 = l2->next;
        }
        s = s->next;
    }
    s->next = NULL;
    //如果还有剩余节点，链在当前链表的尾部
    if(l1!=NULL)s->next = l1;
    if(l2!=NULL)s->next = l2;
    s = head->next;
    return s;
}
