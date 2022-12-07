package com.gzd.leetcode.doubletail;

import java.lang.annotation.ElementType;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 * 快排的分区思想，
 * 找一个临界点
 * 小于临界点的放坐标，大于等于临界点放右边
 *
 * 定义两个指针，一个指向小于目标值的，一个执行大于目标值的
 * 最后拼起来
 *
 */
public class Partition_86 {

    public static void main(String[] args) {
        Partition_86 partition = new Partition_86();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(2);
        ListNode result = partition.partition(listNode, 3);
        System.out.println("");
    }

    public ListNode partition(ListNode head, int x) {


        ListNode sma = new ListNode(-1);
        ListNode res = sma;
        ListNode max = new ListNode(-1);
        ListNode resMax = max;
        ListNode cur = head;
        while (cur != null){
            if (cur.val < x ){
                sma.next = new ListNode(cur.val);
                sma = sma.next;
            }else {
                max.next = new ListNode(cur.val);
                max = max.next;
            }
            cur = cur.next;
        }
        sma.next = resMax.next;
        return res.next;
    }


    public static class ListNode {
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
