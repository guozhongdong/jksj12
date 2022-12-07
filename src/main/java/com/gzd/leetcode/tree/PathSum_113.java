package com.gzd.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class PathSum_113 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);


        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);

        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);

        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);

        PathSum_113 path = new PathSum_113();
        System.out.println(path.pathSum(node, 22));

    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return ans;
        }
        dfs(root, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {

        if (root == null) {
            return;
        }
        // 先将当前元素加入数组中
        list.add(root.val);
        //判断此时的和是否满足
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<>(list));
        }
        // 此时不满足，需要将当前的元素去掉
        dfs(root.left,sum - root.val);
        dfs(root.right,sum - root.val);
        // 走到这一步，说明已经判断过了叶子节点，不满足
        list.remove(list.size()-1);
    }
}
