package com.gzd.leetcode.tree;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 * <p>
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -104 <= Node.val <= 104
 * <p>
 * 任意一棵树进行遍历，知道两个树的节点都为null
 */
public class MergeTrees_617 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);

        TreeNode node2 = new TreeNode(4);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);

        node2.left.right = new TreeNode(1);

        MergeTrees_617 trees = new MergeTrees_617();
        TreeNode result = trees.mergeTrees(node, node2);
        System.out.println(result);


    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        // 两棵树同时为null则网上返回
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null || root2 == null) {
            root1 = root1 == null ? root2 : root1;
            return root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
