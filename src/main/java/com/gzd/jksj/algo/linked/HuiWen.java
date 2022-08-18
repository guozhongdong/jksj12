package com.gzd.jksj.algo.linked;

/**
 * 单链表实现的回文字符串
 *
 * @author guozhongdong
 * @date 2022/8/17 15:46
 */
public class HuiWen {

    /**
     * 判断链表的字符串是否是回文字符串
     * 回文字符串特点
     * 1、对称
     * <p>
     * 注意边界条件
     * 链表为空
     * 链表就一个节点和就两个节点的情况
     * <p>
     * 快慢指针
     */
    public static boolean isHuiWen(Node root) {

        if (root == null) {
            return false;
        }
        if (root.next == null) {
            return true;
        }
        Node fast = root;
        Node slow = root;
        // 先把快指针打到末尾，满指针走到中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此时slow在中点的位置，把slow后面的逆序，
        // 然后从头开始比较
        // 判断是奇数个还是偶数个
        Node left ;
        Node right;
        // 这个地方开始没想到
        if (fast.next == null) {
            // 奇数个
            // 直接取半部分
            right = slow.next;
            // 取翻转后的左半部分
            left = getNode(root, slow).next;
        } else {
            // 直接取半部分
            right = slow.next;
            // 取翻转后的左半部分
            left = getNode(root, slow);
        }
        return isResult(left, right);
    }

    /**
     * 无头节点的链表翻转，翻转中心点的左半部分
     */
    private static Node getNode(Node root, Node convertNode) {

        Node z = root;
        Node pre = null;
        while (z != convertNode) {
            Node cur = z.next;
            z.next = pre;
            pre = z;
            z = cur;
        }
        z.next = pre;
        return z;
    }

    /**
     * 判断是否回文
     */
    private static boolean isResult(Node left, Node right) {

        boolean flag = false;

        while (left != null && right != null) {
            if (left.val == right.val) {
                left = left.next;
                right = right.next;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(3);
        root.next.next.next.next = new Node(2);
        root.next.next.next.next.next = new Node(1);

        //getNode(root, root.next.next);
        System.out.println(isHuiWen(root));

    }
}
