package com.gzd.jksj.algo.linked;

/**
 * 翻转链表
 *
 * @author guozhongdong
 * @date 2022/8/17 12:46
 */
public class ReversLinkedList {

    public static Node reversal(Node node){

        if (node == null || node.next == null){
            return node;
        }
        Node cur = node;
        // 最终翻转后的链表引用
        Node newHead = null;

        while (cur != null){
            Node cur1 = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = cur1;
        }
        return newHead;
    }
}
