package com.gzd.leetcode.doubletail;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 * <p>
 * 快慢指针
 * 快指针走两步，慢指针走一步，快指针到末尾，慢指针到中间
 * <p>
 * 翻转链表
 * <p>
 * 考虑好边界问题
 */
public class IsPalindrome_234 {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        IsPalindrome_234 rome = new IsPalindrome_234();
        System.out.println(rome.isPalindrome(node));
        System.out.println(node);
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            if (head.val != head.next.val) {
                return false;
            } else {
                return true;
            }
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 翻转
        fast = revers(slow.next);
        slow = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;

        }
        return true;
    }


    private ListNode revers(ListNode head) {

        ListNode root = head;
        ListNode curNode = null;
        while (root != null) {
            // 1 2 3 4
            ListNode cur = root.next;
            root.next = curNode;
            curNode = root;
            root = cur;
        }
        return curNode;

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


