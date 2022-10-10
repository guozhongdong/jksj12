package com.gzd.leetcode.stack;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string
 * 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，
 * 且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，
 * 例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300] 
 * <p>
 * 思路：使用栈
 * 遇到第一个数字，记录下来，记录中括号里面完整的字符
 * 递归解析数字加[] 及字符
 */
public class DecodeString_394 {

    public static void main(String[] args) {
        DecodeString_394 decode = new DecodeString_394();
        System.out.println(decode.decodeString("3[abc]"));
        System.out.println(decode.decodeString1("3[abc]"));
    }

    /***
     * 使用双栈，
     * 纯暴力解法
     * 优化空间很大
     *
     */
    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = (c - '0');
                int count = i + 1;
                while (Character.isDigit(s.charAt(count))) {
                    num = num * 10 + (s.charAt(count) - '0');
                    count++;
                }
                stack.push(s.charAt(count));
                i = count;
                stackNum.push(num);

            } else if (c == ']') {
                // 将两个中括号之间的字符转换出来
                StringBuilder sb1 = new StringBuilder();
                while (stack.peek() != '[') {
                    sb1.append(stack.pop());
                }
                // 取出中括号
                stack.pop();
                // 取数字
                int a = stackNum.pop();
                String s2 = sb1.reverse().toString();
                StringBuilder sb2 = new StringBuilder();
                while (a != 0) {
                    sb2.append(s2);
                    a--;
                }
                for (int j = 0; j < sb2.length(); j++) {
                    stack.push(sb2.charAt(j));
                }
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String decodeString1(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();

        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                // 上面循环结束，肯定是遇见了左括号，所以将它压入字符栈
                stackNum.push(num);
            } else if (c == ']') {
                // 将两个中括号之间的字符转换出来
                StringBuilder sb1 = new StringBuilder();
                // 直到遇到左括号停止，sb1 就是两个中间的字符
                while (stack.peek() != '[') {
                    sb1.append(stack.pop());
                }
                // 取出左括号
                stack.pop();
                // 取数字
                int a = stackNum.pop();
                String s2 = sb1.reverse().toString();
                StringBuilder sb2 = new StringBuilder();
                // 遍历拼接
                while (a != 0) {
                    sb2.append(s2);
                    a--;
                }
                // 将组装好的字符再次入栈
                for (int j = 0; j < sb2.length(); j++) {
                    stack.push(sb2.charAt(j));
                }
                i++;
            } else {
                stack.push(c);
                i++;
            }
        }
        // 此时字母栈里面就是最终的结果串，翻转一下即可。
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
