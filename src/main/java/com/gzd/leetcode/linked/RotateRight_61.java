package com.gzd.leetcode.linked;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * 经典题
 * 需要考虑k > 链表长度的情形
 * <p>
 * 1、求k实际的大小
 * 2.旋转，找到旋转点，切开，将后面的部分链接到前面，
 */
public class RotateRight_61 {

    public static void main(String[] args) {
        RotateRight_61 rotateRight = new RotateRight_61();

        ListNode node1 = new ListNode(0);
        node1.next = new ListNode(1);
        /*node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);*/
        ListNode n = rotateRight.rotateRight(node1, 2);
        System.out.println("");
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null ) {
            return head;
        }
        int n = 0;
        ListNode cur = head;
        // 计算链表的长度
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        k = k < n ? k : k % n;
        if (k == 0){
            return head;
        }

        int m = n - k;
        // 1--> 2 --> 3 -->4 --> 5   k ==2
        cur = head;
        // 找到旋转节点的上一个节点，将它的next置为空
        //
        while ( --m > 0){
            cur = cur.next;
        }
        ListNode temp = cur.next;
        if (temp == null){
            return cur;
        }
        ListNode tempLast = temp;
        while (tempLast.next != null){
            tempLast =tempLast.next;
        }
        cur.next = null;
        tempLast.next = head;

        return temp;
    }
}
