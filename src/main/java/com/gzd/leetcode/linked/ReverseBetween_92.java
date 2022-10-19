package com.gzd.leetcode.linked;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *  
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * <p>
 * 关键：一趟遍历
 * 先把正常思路的做出来,画图，别硬想
 *
 * 2、递归
 *
 */
public class ReverseBetween_92 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        //node1.next.next.next.next.next = new ListNode(6);

        ReverseBetween_92 between = new ReverseBetween_92();
        between.reverseBetween(node1, 2, 4);


    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }
        // 正常遍历，记录待翻转区的第一个节点和待翻转区的后一个节点
        ListNode shao = new ListNode(-1);
        shao.next = head;
        ListNode cur = shao;
        // 先找头节点, 找待翻转节点的前一个，便于连接
        // left =2 ;
        for (int i = 0; i < left-1; i++) {
            cur = cur.next;
        }
        // 待翻转的前一个节点
        ListNode pre = cur;
        for (int i = 0; i < right-left+1; i++) {
            cur = cur.next;
        }
        // 待翻转的前一个节点
        ListNode hou = cur;
        // 切除一个自链表，要彻底断开，到时候在链接
        //
        ListNode reversNode = pre.next;
        ListNode tail = hou.next;
        // 断开连接
        pre.next = null;
        hou.next = null;
        ListNode newHead = revers(reversNode);

        // 在拼接上
        pre.next = newHead;
        reversNode.next = tail;

        return shao.next;
    }


    private ListNode revers(ListNode node){
        ListNode head = node;
        ListNode newHead = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
