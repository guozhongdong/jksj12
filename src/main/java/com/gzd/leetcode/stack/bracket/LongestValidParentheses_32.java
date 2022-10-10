package com.gzd.leetcode.stack.bracket;

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 * <p>
 * 思路：使用栈
 * 遇到左括号入栈，遇到右括号，且栈顶元素是左括号，则出栈，长度+2，
 * 如果遇到右括号，栈为空或者不满足，子串长度设置为0,
 */
public class LongestValidParentheses_32 {

    public static void main(String[] args) {
        LongestValidParentheses_32 these = new LongestValidParentheses_32();
        System.out.println(these.longestValidParentheses("((()))"));
    }

    public int longestValidParentheses(String s) {

        if (s == null || s.equals("")) {
            return 0;
        }
        int maxInt = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        // 连续的子串，可以利用下标
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            } else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxInt = Math.max(maxInt,i - stack.peek());
                }
            }

        }

        return maxInt;
    }

}
