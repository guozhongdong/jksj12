package com.gzd.jksj.algo.queue;

import com.gzd.jksj.algo.linked.Node;

/**
 * @author guozhongdong
 * @date 2022/8/19 20:56
 */
public class LinkedQueue {
    /**
     * 指向头节点
     */
    private Node head;

    /**
     * 指向尾节点
     */
    private Node tail;

    private int capacity;

    private int size;

    public LinkedQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 入队
     */
    public boolean enqueue(int val){
        if (size == capacity){
            return false;
        }
        if (tail == null){
           Node newHead = new Node(val);
           tail = newHead;
           head = newHead;
        }else{
            tail.next = new Node(val);
            tail = tail.next;

        }
        size++;
        return true;
    }

    /**
     * 入队
     */
    public int dequeue(){
        if (head == null){
            return -1;
        }
        int val = head.val;
        head = head.next;
        size--;
        if (head == null){
            tail = null;
        }
        return val;
    }

    public static void main(String[] args) {

        LinkedQueue linkedQueue = new LinkedQueue(5);
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(4);
        linkedQueue.enqueue(5);

        System.out.println(linkedQueue.size);
        System.out.println(linkedQueue.head);
        System.out.println(linkedQueue.tail);

        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.size);


    }
}
