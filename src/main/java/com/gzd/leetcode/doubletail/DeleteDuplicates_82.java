package com.gzd.leetcode.doubletail;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * 同83，需要删除重复的节点，
 * 添加一个哨兵节点，
 */
public class DeleteDuplicates_82 {

    public static void main(String[] args) {
        DeleteDuplicates_82 d = new DeleteDuplicates_82();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        //ListNode res = d.deleteDuplicates(head);
        ListNode res1 = d.deleteDuplicates(head);
        //System.out.println(res);
        System.out.println(res1);


    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode fast = root;
        ListNode slow = root;
        // -1 1 1 2 2 3 4
        while (fast.next != null && fast.next.next != null) {
            if (fast.next.val != fast.next.next.val) {
                fast = fast.next;
            } else {
                while (fast.next.next != null && fast.next.val == fast.next.next.val) {
                    fast.next = fast.next.next;
                }
                fast.next = fast.next.next;
            }
            // 知道遇到不相等的，
        }
        return slow.next;
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
