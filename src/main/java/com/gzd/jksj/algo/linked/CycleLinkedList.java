package com.gzd.jksj.algo.linked;

/**
 * 检测链表中是否有环
 *
 * @author guozhongdong
 * @date 2022/8/17 20:06
 */
public class CycleLinkedList {


    /***
     * 思路：快慢指针，如果有环一定回相交
     *
     */
    public static boolean isCycle(Node root){
        if (root == null || root.next == null) {
            return false;
        }
        // 1 2 3 4 5 6 3
        Node fast = root.next;
        Node slow = root;
        // 快指针一次走两步，慢指针一次走一步，不出两圈一定回相交
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.next = new Node(3);
        root1.next.next = new Node(5);
        root1.next.next.next = new Node(7);
        root1.next.next.next.next = root1.next;
        System.out.println(isCycle(root1));
    }
}
