package com.gzd.leetcode.greed.stack;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *  
 *
 * 提示:
 *
 * 2 <= n <= 58
 * 思路：
 * 2-58之间的数，最少拆成两个整数，保证他的成绩是最大的
 *
 *
 *
 */
public class IntegerBreak_343 {

    public static void main(String[] args) {
        IntegerBreak_343 breakT = new IntegerBreak_343();
        System.out.println(breakT.integerBreak(2));
    }

    public int integerBreak(int n) {

        if (n == 2){
            return 1;
        }


        return 0;
    }
}
