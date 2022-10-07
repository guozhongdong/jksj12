package com.gzd.leetcode.stack;

import java.util.*;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * <p>
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * <p>
 * <p>
 * 思路1：先计算乘除，把结果入栈，之后在把栈里面的元素取出来，进行相加
 * 遇到乘除，将栈顶元素与前一个数字相乘，
 * <p>
 * <p>
 * 思路2： 使用栈，遇到数字入栈，遇到符号出栈计算
 * 需要考虑计算的优先级
 * 两个栈，一个放符号，一个放数字
 */
public class Calculate_227 {

    public static void main(String[] args) {
        Calculate_227 calculate = new Calculate_227();
        char c = '*';
        System.out.println('*' - '0');
        System.out.println('+' - '0');
        System.out.println('-' - '0');
        System.out.println('/' - '0');
        System.out.println(calculate.calculate("3+2*2"));
        System.out.println(calculate.calculate1("3+2*2"));
    }

    public int calculate(String s) {

        // 记录运算符后面的数字
        int num = 0;
        // 默认第一个是正数
        char preSign = '+';
        Stack<Integer> stack = new Stack<>();
        // 遇到+号，将数字入栈，
        // 遇到乘或除，将栈顶元素取出，与当前数字计算
        // 3 + 5/2;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 计算数字
            if (Character.isDigit(c) && c != ' ') {
                num = 10 * num + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == chars.length - 1) {
                // 处理第一个数或者前面是加号的数字，压入栈
                if (preSign == '+') {
                    stack.add(num);
                } else if (preSign == '-') {
                    stack.add(-num);
                } else if (preSign == '*') {
                    int a = stack.pop();
                    stack.add(a * num);
                }
                // 处理前面是除号的场景
                else if (preSign == '/') {
                    int a = stack.pop();
                    stack.add(a / num);
                }
                preSign = c;
                num = 0;
            }
        }
        // 直接将栈里面的元素相加
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};


    /**
     * 双栈法，一个放符号，一个放数字
     * 适用于计算表达式的通用套路
     */
    public int calculate1(String s) {
        // 替换所有的空格
        s = s.replaceAll(" ", "");
        // 存放数字
        char[] chars = s.toCharArray();
        int n = chars.length;

        Deque<Integer> nums = new ArrayDeque<>();
        // 防止第一个数为负数的场景
        nums.addFirst(0);
        // 非数字的运算符
        Deque<Character> ops = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                // 将括号内的内容计算完，知道遇到第一个小括号
                while (!ops.isEmpty()) {
                    // 没遇到左括号前，一直计算
                    if (ops.peekLast() != '(') {
                        cal(nums, ops);
                    }
                    // 遇到左括号，将左括号拉出，结束计算
                    else {
                        ops.pollLast();
                        break;
                    }
                }
            }
            // 考虑是数字和普通运算符的场景
            else {
                if (Character.isDigit(c)) {
                    // 细节点：将数字的整体取出 如 345
                    int u = 0;
                    int j = i;
                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                    while (j < n && Character.isDigit(chars[j])) {
                        u = u * 10 + (chars[j++] - '0');
                    }
                    nums.addLast(u);
                    i = j - 1;

                }
                // 加减乘除
                else {
                    // 细节点：
                    if (i > 0 && chars[i - 1] == '(' || chars[i - 1] == '+' || chars[i - 1] == '-') {
                        nums.addLast(0);
                    }
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        if (map.get(prev) >= map.get(c)) {
                            cal(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.addLast(c);
                }

            }
        }
        while (!ops.isEmpty()) {
            cal(nums, ops);
        }
        return nums.peekLast();
    }

    /**
     * 计算结果，并将结果压入数字栈
     */
    void cal(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) {
            return;
        }
        if (ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') ans = a + b;
        else if (op == '-') ans = a - b;
        else if (op == '*') ans = a * b;
        else if (op == '/') ans = a / b;
        else if (op == '^') ans = (int) Math.pow(a, b);
        else if (op == '%') ans = a % b;
        nums.addLast(ans);
    }
}
