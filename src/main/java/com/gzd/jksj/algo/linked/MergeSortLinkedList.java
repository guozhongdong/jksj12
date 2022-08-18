package com.gzd.jksj.algo.linked;

/**
 * 合并两个有序链表
 * 时间复杂度O(m+n)
 * 空间复杂度：O(m+n)
 *
 * @author guozhongdong
 */
public class MergeSortLinkedList {

    /**
     * 合并两个有序链表
     */
    public static Node mergeLinked(Node node1, Node node2) {


        // 先计算两个链表的长度，已长的为底层循环
        if (node1 == null && node2 == null) {
            return null;
        }

        Node root1 = node1;
        Node root2 = node2;
        // 搞一个哨兵节点
        Node res = new Node(-1);
        Node resCur = res;
        // 只要有一个为空，剩下的肯定都是比已合并的大，直接拼接在目标链表后面就行
        while (root1 != null && root2 != null) {
            if (root2.val < root1.val) {
                resCur.next = root2;
                root2 = root2.next;
            } else {
                resCur.next = root1;
                root1 = root1.next;
            }
            resCur = resCur.next;
        }
        // 如果长的还剩下，说明肯定是后面比较大的
        resCur.next = root2 == null ? root1 : root2;

        return res.next;
    }


    /**
     * 递归方法
     * 找准边界条件
     */
    public static Node mergeLinkedList(Node node1, Node node2) {

        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        } else if (node1.val < node2.val) {
            node1.next = mergeLinkedList(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeLinkedList(node1, node2.next);
            return node2;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.next = new Node(3);
        root1.next.next = new Node(5);
        root1.next.next.next = new Node(7);
        root1.next.next.next.next = new Node(9);

        Node root2 = new Node(2);
        root2.next = new Node(4);
        root2.next.next = new Node(10);
        //Node res = mergeLinked(root1, root2);
        Node res = mergeLinkedList(root1, root2);
        System.out.println(res);

    }
}
