package com.gzd.leetcode.linked;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 * 链表经典题
 * 方法一是prev=curr，为什么不是curr=prev
 *
 */
public class ReverseList_206 {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }

        return newHead;
    }
}
