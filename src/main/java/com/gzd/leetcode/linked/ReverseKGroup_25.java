package com.gzd.leetcode.linked;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *  
 * <p>
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *  
 * <p>
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * <p>
 * 通过进阶的提示，可以使用额外空间件的解决
 * 使用栈，每次往栈里面压入k个元素，然后在连起来
 */
public class ReverseKGroup_25 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        //node1.next.next.next.next.next = new ListNode(6);

        ReverseKGroup_25 group = new ReverseKGroup_25();
        group.reverseKGroup(node1, 3);
    }

    /**
     * 暴力解法
     * 1、使用额外空间 栈
     *
     * 2、重新拼接了一个链表
     *
     * 实际改变了节点内部的值，
     *
     * 执行用时：2 ms, 在所有 Java 提交中击败了7.08%的用户
     * 内存消耗：
     * 41.5 MB, 在所有 Java 提交中击败了13.17%的用户
     * 通过测试用例：
     * 62 / 62
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head;

        List<Deque<ListNode>> list = new ArrayList<>();
        while (cur != null) {
            Deque<ListNode> temp = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {
                if (cur != null){
                    ListNode t = cur.next;
                    cur.next = null;
                    temp.add(cur);
                    cur = t;
                }
            }
            list.add(temp);
        }
        ListNode shao = new ListNode(-1);
        ListNode shaobing = shao;

        for (int i = 0; i < list.size(); i++) {
            Deque<ListNode> de = list.get(i);
            if (de.size() == k) {
                while (!de.isEmpty()) {
                    shaobing.next = de.pollLast();
                    shaobing = shaobing.next;
                }
            } else {
                while (!de.isEmpty()) {
                    shaobing.next = de.pollFirst();
                    shaobing = shaobing.next;
                }
            }


        }
        return shao.next;

    }
}
