package com.gzd.leetcode.linked;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 链表的经典题
 * 关键就是找到被删除节点的上一个节点和下一个节点
 * <p>
 * 双指针，先让一个指针走n步，
 * 然后两个指针同时走，当快指针走完的时候，慢指针刚好到n处
 */
public class RemoveNthFromEnd_19 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);
        RemoveNthFromEnd_19 end = new RemoveNthFromEnd_19();
        ListNode rppt = end.removeNthFromEnd(node1, 1);
        System.out.println();

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 设置一个哨兵节点，便于测试
        ListNode root1 = new ListNode(-1);
        root1.next = head;
        ListNode root = root1;
        ListNode fast = root1;
        ListNode slow = root1;

        // -1 --> 1-->2-->3 --> 4 --> 5 --> 6
        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        //
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;

        }
        // 当循环跳出，slow指向的是目标节点的前一个节点
        slow.next = slow.next.next;
        return root.next;
    }
}
