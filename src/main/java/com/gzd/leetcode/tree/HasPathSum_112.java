package com.gzd.leetcode.tree;

/**
 * @author guozhongdong
 * @date 2022/12/4 21:41
 */
public class HasPathSum_112 {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        int num = targetSum - root.val;
        return hasPathSum(root.left, num) || hasPathSum(root.right, num);
    }

    private boolean find(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum) {
            return true;
        }
        int num = targetSum - root.val;
        return find(root.left, num) || find(root.right, num);
    }
}
