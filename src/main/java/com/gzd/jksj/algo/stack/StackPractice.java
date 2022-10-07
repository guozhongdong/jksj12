package com.gzd.jksj.algo.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author guozhongdong
 * @date 2022/8/19 12:33
 */
public class StackPractice {

    public static void main(String[] args) {
        System.out.println(calculate("3+12/5-6"));
        //System.out.println(patternBracket("{[}()]"));
    }

    /**
     * 维护运算符的优先级
     */
    static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};


    /**
     * 计算一个整数加减乘除表达式的结果
     * 如： 3+5*8-6
     * TODO 待完善修改
     */
    public static String calculate(String str) {

        // 先定义两个栈
        // 存放数字
        Stack<Integer> stack1 = new Stack<>();
        // 存放运算符
        Stack<Character> stack2 = new Stack<>();

        // 记录结果的临时变量
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                stack1.push(Character.digit(ch, 10));
            } else {
                // 判断栈顶运算符与当前运算符的优先级、
                while (!stack2.isEmpty()) {
                    // 取栈顶元素
                    char top = stack2.peek();
                    // 判断优先级
                    if (map.get(ch) > map.get(top)) {
                        break;
                    } else {
                        char top1 = stack2.pop();
                        // 从操作数栈里面取两个数使用栈顶运算符进行计算
                        int a = stack1.pop();
                        int b = stack1.pop();
                        sum = cal(b, a, top1);
                        stack1.push(sum);
                    }
                }
                stack2.push(ch);
            }

        }
        while (!stack2.isEmpty()) {
            char top1 = stack2.pop();
            // 从操作数栈里面取两个数使用栈顶运算符进行计算
            int a = stack1.pop();
            int b = stack1.pop();
            sum = cal(b, a, top1);
            stack1.push(sum);
        }

        return sum + "";
    }

    public static int cal(int a, int b, char ch) {

        if (ch == '*') {
            return a * b;
        } else if (ch == '/') {
            return a / b;
        } else if (ch == '+') {
            return a + b;
        } else if (ch == '-') {
            return a - b;
        }
        return 0;
    }

    /**
     * 匹配括号
     * {[] ()[{}]}或[{()}([])]
     */
    public static boolean patternBracket(String str) {

        Stack<Character> left = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                left.push(ch);
            }
            // 遇到右括号,从左栈里弹出一个左括号，不匹配就不符合
            // 如果左栈里空了，说明也不符合
            if (left.isEmpty()) {
                return false;
            }
            if (ch == ')' && left.pop() != '(') {
                return false;
            }
            if (ch == ']' && left.pop() != '[') {
                return false;
            }
            if (ch == '}' && left.pop() != '{') {
                return false;
            }

        }
        if (!left.isEmpty()) {
            return false;
        }
        return true;
    }
}
