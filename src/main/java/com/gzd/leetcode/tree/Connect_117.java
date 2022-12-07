package com.gzd.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * <p>
 * 给定一个二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * 序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 * <p>
 * 输入：root = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在 [0, 212 - 1] 范围内
 * -1000 <= node.val <= 1000
 *  
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 完美二叉树
 * 所有的叶子节点都在一层
 * <p>
 * 广度优先遍历
 */
public class Connect_117 {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.right.right = new Node(5);

        Connect_117 connect = new Connect_117();
        connect.connect1(root);
        System.out.println("");

    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = deque.poll();
                if (i == levelSize - 1) {
                    node.next = null;
                } else {
                    node.next = deque.peek();
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }

        return root;
    }

    /**
     * 递归法
     * 不适用额外空间
     * 关键点1： 给同一个父节点的节点，赋值next
     * 则 node.left.next = node.right
     * <p>
     * 关键点2：不是同一个父节点，但是可以父节点找到下一个节点的父节点
     * node.right.next = node.next.left;
     */
    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            // 下一层
        }
        if (root.left != null && root.right == null) {
            root.left.next = getNext(root.next);
        }
        if (root.right != null){
            root.right.next = getNext(root.next);
        }
        connect1(root.left);
        connect1(root.right);
        return root;
    }


    private Node getNext(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return root.left;
        }
        if (root.right != null) {
            return root.right;
        }
        if (root.next != null) {
            return getNext(root.next);
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
