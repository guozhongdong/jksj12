package com.gzd.leetcode.linked;

/**
 * 你会得到一个双链表，其中包含的节点有一个下一个指针、一个前一个指针和一个额外的 子指针 。
 * 这个子指针可能指向一个单独的双向链表，也包含这些特殊的节点。这些子列表可以有一个或多个自己的子列表，以此类推，
 * 以生成如下面的示例所示的 多层数据结构 。
 * <p>
 * 给定链表的头节点 head ，将链表 扁平化 ，以便所有节点都出现在单层双链表中。让 curr 是一个带有子列表的节点。
 * 子列表中的节点应该出现在扁平化列表中的 curr 之后 和 curr.next 之前 。
 * <p>
 * 返回 扁平列表的 head 。列表中的节点必须将其 所有 子指针设置为 null 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：输入的多级列表如上图所示。
 * 扁平化后的链表如下图：
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：输入的多级列表如上图所示。
 * 扁平化后的链表如下图：
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 说明：输入中可能存在空列表。
 *  
 * <p>
 * 提示：
 * <p>
 * 节点数目不超过 1000
 * 1 <= Node.val <= 105
 *  
 * <p>
 * 如何表示测试用例中的多级链表？
 * <p>
 * 以 示例 1 为例：
 * <p>
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * 序列化其中的每一级之后：
 * <p>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 * <p>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 * <p>
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * <p>
 * 思路：从图可知，优先输出子列表，列表输出完了输出后面的链表
 * 适合递归
 *
 * 很经典的题
 * 边界条件很多
 */
public class Flatten_430 {

    public static void main(String[] args) {
        Flatten_430 flatten = new Flatten_430();
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);

        Node node3 = node1.next.next;
        node3.child = new Node(7);
        node3.next = new Node(4);
        node3.next.next = new Node(5);
        node3.next.next.next = new Node(6);

        Node node7 = node3.child;
        node7.next = new Node(8);

        /*Node node8 = node7.next;

        node8.next = new Node(9);
        node8.next.next = new Node(10);

        node8.child = new Node(11);
        node8.child.next = new Node(12);*/


        flatten.flatten(node1);
    }

    public Node flatten(Node head) {
        digui(head);
        return head;
    }


    /**
     * 递归调用
     * 入参是子列表
     */
    private Node digui(Node head) {

        if (head == null) {
            return null;
        }
        Node last = head;
        while (head != null) {
            // 遍历返回尾节点，做关联使用
            if (head.child == null) {
                last = head;
                head = head.next;
            } else {
                // 如果此时head有字节点，先把它的next节点保存起来，等child节点扁平了，在进行关联
                Node temp = head.next;
                // 一次递归肯定返回的是这次最后一个元素
                Node childLast = digui(head.child);
                /*
                 * 1、将head与next断开
                 * 2、将head 与 head.child 关联起来
                 * 3、如果递归完成了，返回递归的尾节点，则把递归的尾节点与
                 * head的next进行关联
                 * 4、释放child
                 *
                 * last指向head
                 * head 指向 childLast ,下一次从这开始遍历
                 *
                 * 考虑几个边界值，一个当前节点的next节点和pre节点
                 * child节点，遍历完要清空
                 *
                 *
                 */
                head.next = head.child;
                head.child.prev = head;
                if (temp != null){
                    temp.prev = childLast;
                }
                if (childLast != null){
                    childLast.next = temp;
                }
                head.child = null;
                last = head;
                head = childLast;

            }

        }
        return last;
    }


    static class Node {

        public Node(int val) {
            this.val = val;
        }

        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
