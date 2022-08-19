package com.gzd.jksj.algo.queue;

/**
 * 基于数组实现的顺序队列
 *
 * @author guozhongdong
 */
public class ArrayQueue {

    /**
     * 队列的数据载体
     */
    private String[] data;

    private int head;

    private int tail;

    private int size;

    public ArrayQueue(int capacity) {
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
        if (tail == size) {
            // 这个条件标识 tail == size && head == 0没有剩余空间了，
            if (head == 0) {
                return false;
            }
            // 如果tail到队列尾部了，做一次数据搬移的工作
            // 需要搬移的数据是tail - head
            // head --- tail 之间的数据
            for (int i = head; i < tail; i++) {
                data[i - head] = data[i];
            }
            // 搬移完之后，交互指针的指向
            tail = tail - head;
            head = 0;
        }


        data[tail++] = str;
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
        head++;
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
