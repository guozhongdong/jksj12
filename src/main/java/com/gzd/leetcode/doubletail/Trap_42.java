package com.gzd.leetcode.doubletail;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
 * 可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 * <p>
 * 单调栈
 * 双指针
 * 动态规划（还不太理解）
 */
public class Trap_42 {


    public static void main(String[] args) {
        Trap_42 trap = new Trap_42();
        int[] nums = {4, 2, 0, 3, 2, 5};
        System.out.println(trap.trap(nums));
        System.out.println(trap.trap1(nums));
    }

    /**
     * 单调栈
     * 栈维护的整体是单调递减的
     * <p>
     * 当前高度小于等于栈顶高度，入栈，指针后移。
     * <p>
     * 当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，
     * 然后计算当前的高度和新栈的高度的关系，重复第 2 步。直到当前墙的高度不大于栈顶高度或者栈空，
     * 然后把当前墙入栈，指针后移。
     */
    public int trap(int[] height) {

        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            // 规则1,当前高度小于栈顶元素，入栈

            // 4,2,0,3,2,5
            // 核心点，判断过后，需要将top元素出栈，计算的是top的坐标元素和当前元素之间的距离
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // top 元素
                int hi = height[stack.peek()];
                // 将栈顶出栈
                stack.pop();
                // 考虑0 1的情况
                if (stack.isEmpty()) {
                    break;
                }
                // 计算距离
                int d = i - stack.peek() - 1;
                // 计算高度
                int maxHeight = Math.min(height[stack.peek()], height[i]) - hi;
                sum += d * maxHeight;
            }
            stack.push(i);
        }

        return sum;
    }


    /**
     * 双指针
     * 设置一个左柱子和右柱子
     * 如果height[left]
     * <p>
     * <p>
     * 取任意i位置的
     *
     * 当两个指针没有相遇时，进行如下操作：
     *
     * 使用 \textit{height}[\textit{left}]height[left] 和 \textit{height}[\textit{right}]height[right] 的值更新
     * \textit{leftMax}leftMax 和 \textit{rightMax}rightMax 的值；
     *
     * 如果 \textit{height}[\textit{left}]<\textit{height}[\textit{right}]height[left]<height[right]，
     * 则必有 \textit{leftMax}<\textit{rightMax}leftMax<rightMax，下标 \textit{left}left
     * 处能接的雨水量等于 \textit{leftMax}-\textit{height}[\textit{left}]leftMax−height[left]，
     * 将下标 \textit{left}left 处能接的雨水量加到能接的雨水总量，然后将 \textit{left}left 加 11（即向右移动一位）；
     *
     * 如果 \textit{height}[\textit{left}] \ge \textit{height}[\textit{right}]height[left]≥height[right]，
     * 则必有 \textit{leftMax} \ge \textit{rightMax}leftMax≥rightMax，下标 \textit{right}right
     * 处能接的雨水量等于 \textit{rightMax}-\textit{height}[\textit{right}]rightMax−height[right]，
     * 将下标 \textit{right}right 处能接的雨水量加到能接的雨水总量，然后将 \textit{right}right 减 11（即向左移动一位）。
     *

     *
     */
    public int trap1(int[] height) {

        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // 开始比较 左边的小
            // 0,1,0,2,1,0,1,3,2,1,2,1
            if (leftMax <= rightMax){
                sum = sum + (leftMax - height[left]);
                left++;
            }else {
                sum = sum + (rightMax - height[right]);
                right--;
            }
        }

        return sum;
    }

}
