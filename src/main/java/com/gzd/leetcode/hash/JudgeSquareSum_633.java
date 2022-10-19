package com.gzd.leetcode.hash;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= c <= 231 - 1
 * 通过次数121,563提交次数314,629
 *
 * 参考题解：
 * 一般性：如果a^2 + b^2 = c,
 * 不必须要全面枚举，只需要考虑a或者b的任意一个数的平方大于c即可
 * 如c=20,只需要枚举到 5 即可。
 *
 *
 */
public class JudgeSquareSum_633 {

    public static void main(String[] args) {
        System.out.println(Math.floor(Math.sqrt(20)));
        JudgeSquareSum_633 sum = new JudgeSquareSum_633();
        System.out.println(sum.judgeSquareSum1(2147483600));
    }

    /**
     * 使用sqrt函数枚举
     */
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a * a <= c; a++) {

            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针法
     * a 和 b 两个数肯定不会大于c的开平方数
     * 枚举两个数的平方，直到等于c
     * 还有数学公式证明，权当了解
     *
     *
     */
    public boolean judgeSquareSum1(int c) {

        // 先把c开方，并且向上取整
        int b = (int) Math.floor(Math.sqrt(c));
        int a = 0;
        while (a <= b){
            long sum = (long) (a * a) + (long) (b * b);
            if (sum < c){
                a++;
            }else if (sum > c){
                b--;
            }
            if (sum == c){
                return true;
            }

        }
        return false;
    }

}
