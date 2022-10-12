package com.gzd.leetcode.linked;

/**
 * 有一个单链表的 head，我们想删除它其中的一个节点 node。
 * <p>
 * 给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
 * <p>
 * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
 * <p>
 * 删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
 * <p>
 * 给定节点的值不应该存在于链表中。
 * 链表中的节点数应该减少 1。
 * node 前面的所有值顺序相同。
 * node 后面的所有值顺序相同。
 * 自定义测试：
 * <p>
 * 对于输入，你应该提供整个链表 head 和要给出的节点 node。node 不应该是链表的最后一个节点，而应该是链表中的一个实际节点。
 * 我们将构建链表，并将节点传递给你的函数。
 * 输出将是调用你函数后的整个链表。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [2, 1000]
 * -1000 <= Node.val <= 1000
 * 链表中每个节点的值都是 唯一 的
 * 需要删除的节点 node 是 链表中的节点 ，且 不是末尾节点
 * <p>
 * 题目不太好理解，说白了就是让当前不在链表的节点上，直接替换掉链表的连接点就行，不释放节点内存
 */
public class DeleteNode_237 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);


        DeleteNode_237 delete = new DeleteNode_237();
        delete.deleteNode(node1);
    }

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;


    }
}