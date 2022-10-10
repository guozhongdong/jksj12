package com.gzd.leetcode.linked;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
 * 将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例1：
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * 思路：
 * 先将两个链表翻转，遍历每位进行相加，保留进位
 */
public class AddTwoNumbers_445 {

    public static void main(String[] args) {

        AddTwoNumbers_445 twoNumber = new AddTwoNumbers_445();
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(5);
        //node1.next.next = new ListNode(4);
        //node1.next.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
       // node2.next = new ListNode(6);
        //node2.next.next = new ListNode(4);

        //ListNode result = twoNumber.addTwoNumbers(node1, node2);
        ListNode result1 = twoNumber.addTwoNumbers1(node1, node2);
        /*while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }*/
        System.out.println("");
        while (result1 != null) {
            System.out.print(result1.val + " ");
            result1 = result1.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode c1 = convertNode(l1);
        ListNode c2 = convertNode(l2);

        ListNode result = new ListNode(-1);
        ListNode resultNode = result;
        // 开始遍历
        // l1 = [7,2,4,3], l2 = [5,6,4]
        int ans = 0;
        ListNode n1 = c1;
        ListNode n2 = c2;
        while (n1!= null && n2 != null){
            int num = n1.val + n2.val;
            resultNode.next = new ListNode((num + ans) % 10);
            ans = (num + ans)/10;

            n1 = n1.next;
            n2 = n2.next;
            resultNode = resultNode.next;
        }

        while (n1!= null ){
            resultNode.next = new ListNode((n1.val + ans) % 10);
            ans = (n1.val + ans)/10;
            n1 = n1.next;
            resultNode = resultNode.next;
        }

        while (n2!= null ){

            resultNode.next = new ListNode((n2.val + ans) % 10);
            ans = (n2.val + ans)/10;
            n2 = n2.next;
            resultNode = resultNode.next;
        }
        if (ans != 0 ){
            resultNode.next = new ListNode(1);
        }

        return convertNode(result.next);
    }

    private ListNode convertNode(ListNode root){

        if (root == null){
            return null;
        }
        ListNode newHead = null;
        ListNode head = root;
        while (head != null){
            ListNode nextHead = head.next;
            head.next = newHead;
            newHead = head;
            head = nextHead;
        }
        return newHead;
    }


    /**
     * 使用栈优化
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        ListNode c1 = l1;
        ListNode c2 = l2;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (c1!= null){
            stack1.push(c1.val);
            c1 = c1.next;
        }
        while (c2!= null){
            stack2.push(c2.val);
            c2 = c2.next;
        }
        int ans = 0;
        ListNode cur = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || ans != 0){
            int a1=stack1.isEmpty() ? 0 : stack1.pop();
            int a2=stack2.isEmpty() ? 0 : stack2.pop();

            int num = a1 + a2 +ans;
            ListNode cur1 = new ListNode((num)%10);
            ans = (num)/10;
            cur1.next = cur;
            cur = cur1;

        }
        return cur;
    }
}
