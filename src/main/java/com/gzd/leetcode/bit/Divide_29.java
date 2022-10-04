package com.gzd.leetcode.bit;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * 思路：要求限制很多，
 * 1.使用加法替代
 * 累加divisor，记录次数，当大于等于 dividend的时候，累加的次数就是结果
 * 需要考虑符合
 *
 * 看完题解，需要考虑几个边界条件
 * 1、如果给定的数是32位的最小数，如何处理，直接返回
 * 2、被除数和除数的符号考虑
 * 3、
 */
public class Divide_29 {

    public static void main(String[] args) {
        Divide_29 divid = new Divide_29();
        System.out.println(divid.divide(-2147483648, -1));
    }


    /**
     * 待定...... 没算出来
     *
     *
     * */
    public int divide(int dividend, int divisor) {
        // 定义一个变量，考虑如何

        if (dividend == 0){
            return 0;
        }
        if (dividend == divisor){
            return 1;
        }
        if (dividend == Integer.MIN_VALUE){
            if (divisor == 1){
                return Integer.MIN_VALUE;
            }
            if (divisor == -1){
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        boolean fu = false;
        if (dividend < 0 || divisor < 0) {
            fu = true;
        }
        if (dividend < 0 && divisor < 0) {
            fu = false;
        }
        int divid1 = Math.abs(dividend);
        int divisor1 = Math.abs(divisor);
        int count = 0;
        int countSum = divisor1;
        while (countSum <= divid1) {
            countSum += divisor1;
            count++;
        }
        return fu ? -count : count;
    }
}
