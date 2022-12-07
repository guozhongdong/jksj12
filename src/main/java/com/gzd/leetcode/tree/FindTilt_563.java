package com.gzd.leetcode.tree;

/**
 * @author guozhongdong
 * @date 2022/11/24 22:06
 */
public class FindTilt_563 {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(9);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(5);

        node.right.right = new TreeNode(7);
        FindTilt_563 tilt = new FindTilt_563();
        System.out.println(tilt.findTilt(node));
    }

    int ans = 0;

    /**
     * 优化后，将计算坡度的逻辑放到外层
     */
    public int findTilt(TreeNode root) {
        sumNode(root);
        return ans;
    }

    /**
     * 计算节点之和
     */
    public int sumNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        ans += Math.abs(sumNode(root.left) - sumNode(root.right));
        return left + right + root.val;
    }
}
