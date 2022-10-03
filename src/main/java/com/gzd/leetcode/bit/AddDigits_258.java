package com.gzd.leetcode.bit;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * 示例 1:
 * 10 0110 -- 0010
 * 输入: num = 0
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= num <= 231 - 1
 *  
 *
 * 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？
 *
 * 自然数的树根：是自然数的一种性质，每个自然数都有一个数根。对于给定的自然数，反复将各个位上的数字相加，
 * 直到结果为一位数，则该一位数即为原自然数的数根。
 *
 *
 *
 */
public class AddDigits_258 {

    public static void main(String[] args) {
        AddDigits_258 digits = new AddDigits_258();
        System.out.println(digits.addDigits(48));
        System.out.println(digits.addDigits1(48));
    }

    // 38
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int n = num;
        int res = 0;
        while (n != 0) {
            int ge = n % 10;
            res += ge;
            n = n / 10;
        }
        return addDigits(res);
    }


    /**
     * 数学证明法
     *
     */
    public int addDigits1(int num) {
       if (num == 0){
           return 0;
       }else if ((num % 9)  ==  0){
           return 9;
       }else {
           return num % 9;
       }
    }
}
