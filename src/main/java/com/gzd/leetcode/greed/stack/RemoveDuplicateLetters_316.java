package com.gzd.leetcode.greed.stack;

import java.util.Stack;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *  
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 * 参考题解：
 * 遇到一个新字符 如果比栈顶小 并且在新字符后面还有和栈顶一样的 就把栈顶的字符抛弃了
 *
 *
 */
public class RemoveDuplicateLetters_316 {

    public static void main(String[] args) {
        System.out.println('a' > 'c');
        RemoveDuplicateLetters_316 remove = new RemoveDuplicateLetters_316();
        System.out.println(remove.removeDuplicateLetters("cbacdcbc"));
    }

    /**
     * 单调栈，从小到排列
     * 遇到一个新字符 如果比栈顶小 并且在新字符后面还有和栈顶一样的 就把栈顶的字符抛弃了
     */
    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.contains(c)){
                continue;
            }
            // 如果栈顶元素大于当前元素，并且后面还有根栈顶元素相同的元素，则把栈顶元素弹出
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(),i) != -1){
                stack.pop();
            }
            stack.push(c);
        }
        // 出栈，拼装字符串
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 暴力
     */
    public String removeDuplicateLetters1(String s) {

        return null;
    }
}
