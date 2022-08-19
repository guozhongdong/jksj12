package com.gzd.jksj.algo.queue;

/**
 * 数组实现循环队列
 *
 * @author guozhongdong
 */
public class CycleQueue {

    /**
     * 队列的数据载体
     */
    private String[] data;

    private int head;

    private int tail;

    private int size;

    public CycleQueue(int capacity) {
        this.data = new String[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = capacity;

    }

    /**
     * 入队
     */
    public boolean enqueue(String str) {
        // 说明队列满了，不能再加了，
        if ((tail + 1) % size == head) {
            return false;
        }
        data[tail] = str;
        head = (tail + 1) % size;
        return true;
    }

    public int size() {
        return size;
    }

    /**
     * 出队
     */
    public String dequeue() {
        // 说明到底了，没有元素了，
        if (head == tail) {
            return null;
        }
        String element = data[head];
        data[head] = null;
        head = (head + 1) % size;
        return element;
    }

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");

        System.out.println(queue.size());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.enqueue("h"));
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
    }
}
