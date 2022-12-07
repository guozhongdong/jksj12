package com.gzd.leetcode.tree;

/**
 * @author guozhongdong
 * @date 2022/11/27 21:24
 */
public class LongestUnivaluePath_687 {

    public static void main(String[] args) {

    }

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {

        cal(root);
        return ans;
    }


    private int cal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 每个根节点对应的最大长度==左边的最大长度+右边的最大长度
        int left = cal(root.left);
        int right = cal(root.right);
        // 关键计算点
        int left1 = 0;
        int right1 = 0;
        if (root.left != null && root.val == root.left.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            right1 = right + 1;
        }
        ans = Math.max(ans, left1 + right1);
        return Math.max(left1, right1);
    }

}
