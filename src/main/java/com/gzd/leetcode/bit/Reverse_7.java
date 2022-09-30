package com.gzd.leetcode.bit;

/**
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 *
 *
 * @author guozhongdong
 * @date 2022/9/27 21:25
 */
public class Reverse_7 {

    public static void main(String[] args) {
        Reverse_7 reverse = new Reverse_7();
        System.out.println(1534236469);
        System.out.println(Integer.MAX_VALUE );
        System.out.println(reverse.reverse(1534236469));
    }

    /**
     * 字符串翻转不行，溢出
     * 使用数学法
     *
     */
    public int reverse(int x) {

        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return 0;
        }
        int rev = 0;
        /// 123
        while (x != 0){
            if (rev  > Integer.MAX_VALUE/10 || rev < Integer.MIN_VALUE/10){
                return 0;
            }
            // 3
            int digit = x % 10;
            // 12
            x = x/10;
            // 0 + 23
            // 3 * 10 +2 =32
            // 32 * 10 + 1 = 321

            rev = rev * 10 + digit;


        }

        return rev;
    }
}
