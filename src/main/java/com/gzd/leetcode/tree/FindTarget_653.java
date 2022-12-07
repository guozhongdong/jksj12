package com.gzd.leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * 示例 2：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 *  
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * 题目数据保证，输入的 root 是一棵 有效 的二叉搜索树
 * -105 <= k <= 105
 * <p>
 * 关键题意，二叉搜索树
 * 中序遍历是升序的
 */
public class FindTarget_653 {

    public static void main(String[] args) {
        FindTarget_653 target = new FindTarget_653();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);

        node.right.right = new TreeNode(7);

        System.out.println(target.findTarget(node, 4));
    }

    /**
     * 已某个节点为根节点，寻找另一个值
     */
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    /**
     * 中序遍历+双指针
     */
    List<Integer> list = new ArrayList<>();

    public boolean findTarget1(TreeNode root, int k) {

        if (root == null) {
            return false;
        }
        dfs(root);
        int left = 0;
        int right = list.size()-1;
        while (left < right){
            if (list.get(left) + list.get(right) > k){
                right--;
            }else if (list.get(left) + list.get(right) < k){
                left++;
            }else {
                return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

}
