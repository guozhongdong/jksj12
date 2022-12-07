package com.gzd.leetcode.tree;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
 *
 * 如果第二小的值不存在的话，输出 -1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 *
 *
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 *
 * 从题意可知，根节点如果有左右节点，则肯定等于其中一个节点，
 * 根节点是最小值，找到比根节点大的最小值
 *
 *
 */
public class FindSecondMinimumValue_671 {

    public static void main(String[] args) {

    }

    int minValue;
    int ans;

    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        minValue = root.val;
        find(root);
        return ans;
    }

    /**
     * 找所有子树的最小值，且比根节点大
     */
    private void find(TreeNode root){
        if (root == null){
            return ;
        }
        // 此时说明ans就是第二大的了
        if (ans != -1 && root.val > ans){
            return;
        }
        // 上面不满足，说明此时的值，比ans小，然后判断是否大于最小值
        if (root.val > minValue){
            ans = root.val;
        }
        find(root.left);
        find(root.right);
    }

}
