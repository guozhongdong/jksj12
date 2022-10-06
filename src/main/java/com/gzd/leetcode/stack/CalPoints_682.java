package com.gzd.leetcode.stack;

import java.util.Stack;

/**
 * 棒球比赛-682
 * <p>
 * 示例 1：
 * <p>
 * 输入：ops = ["5","2","C","D","+"]
 * 输出：30
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 * 示例 2：
 * <p>
 * 输入：ops = ["5","-2","4","C","D","9","+","+"]
 * 输出：27
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "-2" - 记录加 -2 ，记录现在是 [5, -2]
 * "4" - 记录加 4 ，记录现在是 [5, -2, 4]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
 * "D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
 * "9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
 * "+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
 * "+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
 * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
 * 示例 3：
 * <p>
 * 输入：ops = ["1"]
 * 输出：1
 * <p>
 * 使用栈，入栈出栈
 */
public class CalPoints_682 {

    public static void main(String[] args) {
        CalPoints_682 calPoints = new CalPoints_682();
        String[] strs = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints.calPoints(strs));
    }

    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            String s = operations[i];
            if (s.equals("C")) {
                stack.pop();
            }
            // 表示前一个回合的两倍
            else if (s.equals("D")) {
                stack.add(stack.peek() * 2);
            } else if (s.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();

                stack.add(a);
                stack.add(a+b);
            } else {
                stack.add(Integer.parseInt(s));
            }
        } int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
