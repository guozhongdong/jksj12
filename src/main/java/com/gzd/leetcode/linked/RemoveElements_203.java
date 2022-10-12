package com.gzd.leetcode.linked;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * <p>
 * 思路
 * 1、一次遍历，val等于目标数删除
 * 2、考虑空值，和链表的元素都等于目标数的场景
 */
public class RemoveElements_203 {

    public static void main(String[] args) {
        RemoveElements_203 remove = new RemoveElements_203();
        ListNode node1 = new ListNode(6);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(6);
        node1.next.next.next = new ListNode(6);
        node1.next.next.next.next = new ListNode(6);
        node1.next.next.next.next.next = new ListNode(6);
        System.out.println(remove.removeElements(node1,6));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 1 2 6 3 4 5 6
        ListNode cur = new ListNode(-1);
        ListNode curExe = cur;
        curExe.next = head;
        while (cur.next != null ) {
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur =cur.next;
            }
        }
        return curExe.next;
    }
}
