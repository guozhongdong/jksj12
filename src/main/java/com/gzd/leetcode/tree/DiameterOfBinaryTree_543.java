package com.gzd.leetcode.tree;

/**
 *
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 *
 */
public class DiameterOfBinaryTree_543 {

    public static void main(String[] args) {


        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        DiameterOfBinaryTree_543 trees = new DiameterOfBinaryTree_543();
        System.out.println(trees.diameterOfBinaryTree(node));
    }
    int ans ;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        cal(root);
        return ans -1;
    }

    /*
    *  计算树的深度
    **/
    public int cal(TreeNode root) {

        if (root == null){
            return 0;
        }
        int L = cal(root.left);
        int R = cal(root.right);
        ans = Math.max(ans,L+R+1);
        return 1+Math.max(L,R);
    }
}
