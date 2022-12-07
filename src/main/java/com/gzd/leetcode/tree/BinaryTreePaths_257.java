package com.gzd.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhongdong
 * @date 2022/12/1 22:41
 */
public class BinaryTreePaths_257 {


    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        // 使用栈存储节点信息
        dfs(root, "", ans);

        return ans;
    }

    /**
     * 深度优先遍历
     *
     * @param path 代表从上面带过来的路径
     */
    private void dfs(TreeNode root, String path, List<String> list) {

        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        if (root.left == null && root.right == null){
            // 当前节点是叶子节点
            list.add(sb.toString());
        }else {
            sb.append("->");
            dfs(root.left,sb.toString(),list);
            dfs(root.right,sb.toString(),list);
        }
    }
}
