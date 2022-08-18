package com.gzd.jksj.algo.linked;

/**
 * 基于链表实现的LRU
 *
 * @author guozhongdong
 * @date 2022/8/16 21:42
 */
public class LinkedLru {

    /**
     * 缓存数据的载体
     */
    Node head;

    /**
     * 缓存的容量
     */
    private int capacity;

    /**
     * 实际变化的数量
     */
    private int count;

    /**
     * 构造初始化容量
     */
    public LinkedLru(int capacity){
        this.capacity = capacity;
        this.head = new Node(0);
    }

    /**
     * 添加元素
     */
    public Node addNode(int val){
        // 查找元素
        Node nodePre = searchNode(val);
        if (nodePre != null){
            // 删除原节点，且在头部插入新节点
            deleteNode(nodePre);
            insertNode(val);
        }else {
            // 如果添加的元素，不在缓存里，
            // 如果缓存已满，则删除尾结点，插入头节点
            if (count >= capacity){
                // 删除尾结点
                deleteTailNode();

            }
            insertNode(val);
        }
        return head;
    }

    /**
     * 考虑边界值
     *
     */
    private void deleteTailNode() {
        // 如果就一个节点,则直接返回null
        Node cur = head.next;
        if (cur.next == null){
            head.next = null;
            return;
        }
        // 遍历寻找尾节点的上一个节点
        while (cur.next.next != null){
            cur = cur.next;
        }
        // 跳出循环，说明cur.next 是为尾节点，删除它
        cur.next = null;
        count--;
    }

    /**
     * 插入头节点
     */
    private void insertNode(int val) {
        Node pre = head.next;
        Node newHead = new Node(val);
        newHead.next = pre;
        head.next = newHead;
        count++;

    }

    /**
     * 删除当前节点
     */
    private void deleteNode(Node preNode) {
        // 需要删除的节点
        Node cur = preNode.next;
        preNode.next = cur.next;
        count--;
    }


    /**
     * 查询元素，并返回当前元素所在的结点
     */
    private Node searchNode(int val) {

        Node cur = head;
        while (cur != null && cur.next != null){
            if (cur.next.val == val){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedLru lru = new LinkedLru(4);
        lru.addNode(1);
        lru.addNode(2);
        lru.addNode(3);
        lru.addNode(4);

        System.out.println(lru.head);
        System.out.println(lru.addNode(5));
        System.out.println(lru.head);

        System.out.println(lru.addNode(3));
        System.out.println(lru.head);

    }
}
