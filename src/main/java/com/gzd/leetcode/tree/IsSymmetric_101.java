package com.gzd.leetcode.tree;

import java.util.LinkedList;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *  
 * <p>
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * 广度优先遍历
 * 将树的值，放到一个队列中， 按层遍历，遍历完，比较队列两端的值是否相等，
 * <p>
 * 镜像的特征
 */
public class IsSymmetric_101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);

    }

    private boolean check(TreeNode root1, TreeNode root2) {
        // 定义一个双端队列
        LinkedList<TreeNode> deque = new LinkedList<>();
        // 将第一个节点的值放进去
        deque.offer(root1);
        deque.offer(root2);
        while (!deque.isEmpty()) {
            root1 = deque.poll();
            root2 = deque.poll();
            if (root1 == null && root2 == null) {
                continue;
            }
            if ((root1 == null || root2 == null) || (root1.val != root2.val)) {
                return false;
            }
            // 关键点，将元素放入到队列中，按镜像的模式放
            deque.offer(root1.left);
            deque.offer(root2.right);

            deque.offer(root1.right);
            deque.offer(root2.left);
        }
        return true;
    }


}
