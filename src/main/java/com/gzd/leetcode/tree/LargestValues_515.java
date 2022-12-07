package com.gzd.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author guozhongdong
 * @date 2022/11/30 21:55
 */
public class LargestValues_515 {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            int max = deque.peek().val;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            ans.add(max);
        }
        return ans;

    }
}
