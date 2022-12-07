package com.gzd.leetcode.tree;

import java.util.List;

/**
 * @author guozhongdong
 * @date 2022/11/29 20:58
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
