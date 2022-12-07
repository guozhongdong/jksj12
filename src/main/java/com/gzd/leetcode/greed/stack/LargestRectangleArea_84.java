package com.gzd.leetcode.greed.stack;

import java.util.Stack;

/**
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 *
 *
 *
 * 输入： heights = [2,4]
 * 输出： 4
 *  
 *
 * 提示：
 *
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 *
 * 套用单调栈模板
 * 需要考虑相邻的柱子的最大值
 *
 * 不会做，也看不懂题解
 *
 *
 */
public class LargestRectangleArea_84 {

    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        if (n == 0){
            return 0;
        }

        int maxSum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = heights[i];
            while (!stack.isEmpty() && stack.peek() * stack.size() < num){
                stack.pop();
            }

            stack.push(num);
        }

        return 1;
    }
}
