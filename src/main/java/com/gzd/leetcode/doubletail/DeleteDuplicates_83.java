package com.gzd.leetcode.doubletail;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。
 * 返回 已排序的链表 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * 双指针，定义两个指针，如果下一个节点跟当前节点相等，则其中一个节点往下走，直到遇到不相等的节点，
 * 则把当前节点指向，下一个不同的节点，
 */
public class DeleteDuplicates_83 {

    public static void main(String[] args) {
        DeleteDuplicates_83 d = new DeleteDuplicates_83();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        //ListNode res = d.deleteDuplicates(head);
        ListNode res1 = d.deleteDuplicates1(head);
        //System.out.println(res);
        System.out.println(res1);


    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
            if (fast == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next;

        }

        return head;
    }

    /**
     * 好像题解的方法，更容易
     * 定义一个指针
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        while (fast.next != null) {
            if (fast.val == fast.next.val) {
                fast.next = fast.next.next;
            } else {
                fast = fast.next;
            }
        }
        return head;
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
