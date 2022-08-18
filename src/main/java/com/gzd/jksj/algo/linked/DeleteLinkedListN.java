package com.gzd.jksj.algo.linked;

/**
 * 删除链表倒数第n个节点
 * <p>
 * 思路：已知n，那就让一个指针走n个节点
 * 然后在定义一个指针，从头开始走，
 * <p>
 * 1 --> 2 --> 3 --> 4 --> 5
 * <p>
 * n =2
 * 最终结果应该是
 * 1 --> 2 --> 3 --> 5
 *
 * @author guozhongdong
 * @date 2022/8/17 20:07
 */
public class DeleteLinkedListN {

    /**
     * 考虑边界值，一个元素，两个元素的收，删除一个怎么处理
     */
    public static Node deleteN(Node root, int n) {

        if (root == null) {
            return null;
        }
        Node shao = new Node(0);
        shao.next = root;

        Node cur = shao.next;
        int count = 0;
        while (count < n) {
            cur = cur.next;
            count++;
        }
        // 此时cur应该是正着走了n步，但是cur保存的是next节点
        Node preDel = shao;
        while (cur != null) {
            cur = cur.next;
            preDel = preDel.next;
        }
        preDel.next = preDel.next.next;
        return shao.next;
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        //root1.next = new Node(2);
       /* root1.next.next = new Node(3);
        root1.next.next.next = new Node(4);
        root1.next.next.next.next = new Node(5);*/
        System.out.println(deleteN(root1, 1));
    }

}
