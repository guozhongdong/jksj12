package com.gzd.leetcode.linked;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 思路：
 * 直接遍历交换
 * 注意边界值
 * <p>
 * 差点把我绕进去
 * 递归
 */
public class SwapPairs_24 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        SwapPairs_24 swap = new SwapPairs_24();
        swap.swapPairs(node1);

    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur = root;
        while (cur.next != null && cur.next.next != null) {
            // 1 -- 2 -- 3 --4 --5
            // next --> 2
            ListNode result1 = cur.next;
            ListNode result2 = cur.next.next;
            // temp -- > 3
            // 2.next = 4 连上了 ，关键
            cur.next = result2;
            result1.next = result2.next;
            result2.next = result1;
            // 类似哑节点
            cur = result1;
        }

        System.out.println();

        return root.next;
    }


    /**
     * 递归法
     * 看边界条件判断很满足
     */
    public ListNode swapPairs1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        // 1-- > 2 --> 3 --> 4 --> 5
        // 2
        ListNode newHead = head.next;
        // 将2 后面的继续递归转换
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
