package com.gzd.leetcode.tree;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class MinDepth_111 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(5);
        node.right.right.right.right = new TreeNode(6);
        MinDepth_111 minD = new MinDepth_111();
        System.out.println(minD.minDepth(node));

    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minD = 0;
        int leftNum = 0;
        int rightNum = 0;
        if (root.left != null) {
            leftNum = minDepth(root.left);
        }
        if (root.right != null) {
            rightNum = minDepth(root.right);
        }
        if (leftNum > 0 && rightNum > 0) {
            minD = Math.min(leftNum, rightNum);
        } else if (leftNum > 0) {
            minD = leftNum;
        } else if (rightNum > 0) {
            minD = rightNum;
        }
        return 1 + minD;
    }
}
