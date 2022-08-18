package com.gzd.jksj.algo.linked;

/**
 * 求链表的中间节点
 *
 * @author guozhongdong
 * @date 2022/8/17 20:08
 */
public class LinkedMiddleNode {

    public static Node findMiddleNode(Node root){

        if (root == null){
            return null;
        }
        Node fast = root;
        Node slow = root;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
