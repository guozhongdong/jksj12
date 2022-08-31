package com.gzd.jksj.algo.skiplist;

import java.util.Random;

/**
 * 跳跃表的实现
 *
 * @author guozhongdong
 */
public class SkipList {

    // 最大层数
    private static final int MAX_LEVEL = 16;

    // 最大层数
    private int levelCount = 0;

    // 链表节点
    private Node head = new Node(MAX_LEVEL);

    private Random r = new Random();

    /**
     * 查找元素
     */
    public Node find(int value) {

        Node p = head;
        // 从最大层开始找
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {

                // 传递到下一个节点
                p = p.forwards[i];
            }
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    /**
     * 插入
     * 创建新节点，每一层设置数据
     * 找到前后节点
     */
    public void insert(int value, int level) {
        // 取随机数
        if (level == 0) {
            level = randomLevel();
        }
        // 创建新节点
        Node newNode = new Node(level);
        newNode.data = value;
        newNode.maxLevel = level;
        // 记录要更新的层数，表示新节点要更新到哪几层
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        Node p = head;
        /**
         * 层从上往下寻找，
         * 随机层可能会存在问题，1亿的数据，层数是1，退化成链表了，
         *
         */
        // 查找节点要插入的位置,遍历head 找到值小于value的节点
        for (int i = level - 1; i >= 0; i--) {
            // 从头节点开始查找
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 一直找，直到找到大于value的值
                p = p.forwards[i];
            }
            // 将新节点对应的层数数据更新上
            update[i] = p;

        }
        // 前后关联
        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
        // 更新层高
        if (levelCount < level) {
            levelCount = level;
        }


    }

    /**
     * 插入
     * 创建新节点，每一层设置数据
     * 找到前后节点
     */
    public void insert1(int value) {
        // 取随机数
        int level = head.forwards[0]==null ? 1:  randomLevel();
        if (level > levelCount){
            level = ++levelCount;
        }
        // 创建新节点
        Node newNode = new Node(level);
        newNode.data = value;
        newNode.maxLevel = level;
        // 记录要更新的层数，表示新节点要更新到哪几层
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        Node p = head;
        /**
         * 层从上往下寻找，
         * 随机层可能会存在问题，1亿的数据，层数是1，退化成链表了，
         *
         */
        // 查找节点要插入的位置,遍历head 找到值小于value的节点
        for (int i = level - 1; i >= 0; i--) {
            // 从头节点开始查找
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 一直找，直到找到大于value的值
                p = p.forwards[i];
            }
            // 将新节点对应的层数数据更新上
            if (level > i){
                update[i] = p;
            }

        }
        // 前后关联
        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
    }

    /**
     * 删除节点
     *
     * 需要考虑每一层的数据都需要删除
     *
     */
    public void delete(int value){

        Node p = head;
        Node[] update = new Node[levelCount];
        for (int i = levelCount-1; i >=0 ; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            update[i] = p;
        }
        // 需要考虑删除每一层的数据
        if (p.forwards[0] != null && p.forwards[0].data == value){
            for (int i = levelCount-1; i >= 0 ; --i) {
                if (update[i].forwards[i]!=null && update[i].forwards[i].data == value){
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

    }
    /**
     * 插入
     * 创建新节点，每一层设置数据
     * 找到前后节点
     */
    public void insert2(int value) {
        // 取随机数
        int level = head.forwards[0]==null ? 1:  randomLevel();
        if (level > levelCount){
            level = ++levelCount;
        }
        // 创建新节点
        Node newNode = new Node(level);
        newNode.data = value;
        // 记录要更新的层数，表示新节点要更新到哪几层
        Node p = head;
        /**
         * 层从上往下寻找，
         * 随机层可能会存在问题，1亿的数据，层数是1，退化成链表了，
         *
         */
        // 查找节点要插入的位置,遍历head 找到值小于value的节点
        for (int i = level - 1; i >= 0; i--) {
            // 从头节点开始查找
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 一直找，直到找到大于value的值
                p = p.forwards[i];
            }
            if (level > i){
                if (p.forwards[i] == null){
                    p.forwards[i] = newNode;
                }else{
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }

        }


    }

    /**
     * 随机 level 次，如果是奇数层数 +1，防止伪随机
     *
     * @return
     */
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }


    /**
     * 跳表节点
     */
    private class Node {

        // 节点数据
        private int data = -1;

        /**
         * 指当前节点指向下一个节点，所有层的数据
         * 0 1 2
         * forwards[2] 指当前节点在第三层指向的下一个节点
         */
        private Node[] forwards;

        private int maxLevel = 1;

        // 最大层数
        public Node(int level) {
            forwards = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    /**
     * 打印每个节点数据和最大层数
     */
    public void printAll() {
        SkipList.Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    /**
     * 打印所有数据
     */
    public void printAll_beautiful() {
        SkipList.Node p = head;
        SkipList.Node[] c = p.forwards;
        SkipList.Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print((d[i] != null ? d[i].data : null) + ":" + i + "-------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
    }

    public static void main(String[] args) {

        /*SkipList list = new SkipList();
        list.insert(1, 4);
        list.insert(3, 1);
        list.insert(4, 2);
        list.insert(5, 1);
        list.insert(6, 1);
        list.insert(8, 1);
        list.insert(7, 3);
        list.insert(9, 2);
        list.insert(10, 1);
        list.insert(13, 4);
        list.insert(16, 1);
        list.insert(17, 2);
        list.insert(18, 1);
        list.printAll_beautiful();
        list.printAll();
        Node n = list.find(6);
        System.out.println();*/


        SkipList list1 = new SkipList();
        list1.insert2(1);
        list1.insert2(3);
        list1.insert2(4);
        list1.insert2(5);
        list1.insert2(6);
        list1.insert2(8);
        list1.insert2(7);
        list1.insert2(9);
        list1.insert2(10);
        list1.insert2(13);
        list1.insert2(16);
        list1.insert2(17);
        list1.insert2(18);
        list1.printAll_beautiful();
        list1.printAll();
        Node n1 = list1.find(6);
        System.out.println();
    }

}
