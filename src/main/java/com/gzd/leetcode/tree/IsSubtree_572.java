package com.gzd.leetcode.tree;

/**
 *
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 *
 * 遍历主树，如果当前节点与子树的根节点相等，则递归遍历左子树和右子树
 *
 */
public class IsSubtree_572 {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);


        TreeNode node2 = new TreeNode(1);

        //node2.left.right = new TreeNode(1);

        IsSubtree_572 trees = new IsSubtree_572();
        System.out.println(trees.isSubtree(node, node2));


    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null){
            return false;
        }
        return check(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot){

        if (root == null && subRoot == null){
            return true;
        }

        if (root == null || subRoot == null){
            return false;
        }
        if (root.val == subRoot.val){
            return check(root.left,subRoot.left) &&
                    check(root.right,subRoot.right);
        }
        return false;

    }
}
