package com.gzd.jksj.algo.stack;

import com.gzd.jksj.algo.linked.Node;

/**
 * 链表实现一个栈
 * 先进后出，后出先进
 *
 * @author guozhongdong
 * @date 2022/8/18 22:36
 */
public class LinkedStack {

    /**
     * 栈的数据载体
     */
    private Node data;

    /**
     * 栈的容量
     */
    private int capacity;

    /**
     * 栈中已保存的数据
     */
    private int count;

    public LinkedStack(int capacity) {

        this.capacity = capacity;
        data = new Node(0);
        this.count = 0;
    }

    /**
     * 入栈
     * 插入在链表的头部位置
     */
    public void push(int value) {
        // 满了直接返回失败
        if (count >= capacity) {
            return;
        }
        Node head = new Node(value);
        head.next = data.next;
        data.next = head;
        count++;
    }

    /**
     * 弹出栈
     */
    public int pop() {
        // 如果从栈尾取一个元素
        Node head = data.next;
        if (head == null){
            return -1;
        }
        // 处理特殊情况，就一个节点
        if (head.next == null){
            data.next = null;
            return head.val;
        }
        // 如果后面还有节点，将头节点返回，后面节点变成头节点
        int element = head.val;
        data.next = head.next;
        return element;

    }


    public static void main(String[] args) {

        LinkedStack linkedStack = new LinkedStack(5);
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);

        System.out.println(linkedStack.count);
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());

    }
}
