package com.gzd.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *  
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1 
 * <p>
 * 广度优先遍历
 */
public class FindBottomLeftValue_513 {


    public int findBottomLeftValue(TreeNode root) {

        int leftValue = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node.right != null) {
                deque.add(node.right);
            }
            if (node.left != null) {
                deque.add(node.left);

            }
            leftValue = node.val;
        }
        return leftValue;
    }

    int leftValue = 0;
    int curHeight = 0;
    public int findBottomLeftValue1(TreeNode root) {

        dfs(root,0);
        return leftValue;
    }

    private void dfs(TreeNode root,int height) {
        if (root == null){
            return;
        }
        height++;
        dfs(root.left,height);
        dfs(root.right,height);
        if (height > curHeight){
            leftValue = root.val;
            curHeight = height;
        }
    }


}
