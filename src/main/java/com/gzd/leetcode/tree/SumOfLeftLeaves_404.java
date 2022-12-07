package com.gzd.leetcode.tree;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 示例 2:
 * <p>
 * 输入: root = [1]
 * 输出: 0
 *  
 * <p>
 * 提示:
 * <p>
 * 节点数在 [1, 1000] 范围内
 * -1000 <= Node.val <= 1000
 *
 * @date 2022/12/5 21:35
 */
public class SumOfLeftLeaves_404 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        SumOfLeftLeaves_404 leaves_404 = new SumOfLeftLeaves_404();
        System.out.println(leaves_404.sumOfLeftLeaves(node));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 只取左叶子节点
        return sumLeft(root.left, true) + sumLeft(root.right, false);
    }

    private int sumLeft(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        // 左叶子节点
        if (root.left == null && root.right == null && flag) {
            return root.val;
        }
        return sumLeft(root.left, true) + sumLeft(root.right, false);
    }
}
