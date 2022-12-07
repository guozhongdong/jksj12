package com.gzd.leetcode.tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * <p>
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * <p>
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 * <p>
 * 关键定义：
 * 1、给每个节点标注一个索引值，
 * 当前节点index
 * 左节点为：2 *index
 * 右节点为：2 * index +1
 * <p>
 * 最终的结果是拿每一层的最右下标 减去 最左下标+ 1
 */
public class WidthOfBinaryTree_662 {

    public int widthOfBinaryTree(TreeNode root) {


        if (root == null) {
            return 0;
        }
        int max = 0;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<>();
        arr.add(new Pair(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> temp = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                Pair<TreeNode, Integer> cur = arr.get(i);
                TreeNode curNode = cur.getKey();
                int index = cur.getValue();
                if (curNode.left != null) {
                    temp.add(new Pair<>(curNode.left, 2 * index));
                }
                if (curNode.right != null) {
                    temp.add(new Pair<>(curNode.right, 2 * index + 1));
                }
            }

            max = Math.max(max, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = temp;
        }
        return max;
    }
}
