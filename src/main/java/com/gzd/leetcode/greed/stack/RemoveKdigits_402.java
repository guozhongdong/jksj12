package com.gzd.leetcode.greed.stack;

import java.util.Stack;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，
 * 使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 *
 *  
 * 示例 1 ：
 *
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 *
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 *
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 *  
 *
 * 提示：
 *
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 *
 * 从头开始遍历
 * 1432219 k=3
 *
 * 从高位开始
 *
 *
 */
public class RemoveKdigits_402 {
    public static void main(String[] args) {

        RemoveKdigits_402 digit = new RemoveKdigits_402();
        System.out.println(digit.removeKdigits("112",1));
        System.out.println('1' > '2');
    }

    public String removeKdigits(String num, int k) {
        if (k == num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            // 栈顶元素比当前元素大，则弹出栈顶，当前元素入栈

            while (!stack.isEmpty() && stack.peek() > c && count < k){
                count++;
                stack.pop();
            }
            stack.push(c);
        }
        // 得考虑实际走完，后面的都比前面的大，那就把后面的数字去掉就可以
        for (int i = 0; i < k-count; ++i) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String res = trimStringWith(sb.reverse().toString(),'0');
        return res.equals("") ? "0" : res;
    }

    private String trimStringWith(String str, char beTrim) {
        int st = 0;
        int len = str.length();
        char[] val = str.toCharArray();
        char sbeTrim = beTrim;
        while ((st < len) && (val[st] == sbeTrim)) {
            st++;
        }
        return (st > 0) ? str.substring(st, len) : str;
    }
}
