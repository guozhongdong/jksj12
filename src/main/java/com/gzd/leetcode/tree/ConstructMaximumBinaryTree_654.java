package com.gzd.leetcode.tree;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 * <p>
 * 从数组中找到最大值，气氛n
 */
public class ConstructMaximumBinaryTree_654 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        ConstructMaximumBinaryTree_654 tree = new ConstructMaximumBinaryTree_654();
        TreeNode node = tree.constructMaximumBinaryTree(nums);
        System.out.println(node);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }
        // 每次从数组中找到一个 最大值构造根节点
        int best = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[best]) {
                best = i;
            }
        }
        // 构造根节点
        TreeNode node = new TreeNode(nums[best]);
        node.left = construct(nums,left,best-1);
        node.right= construct(nums,best+1,right);
        return node;
    }
}
