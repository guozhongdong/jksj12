package com.gzd.leetcode.bit;

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 104
 *  
 *
 *
 * 尾数0，可以看成是10的乘积
 * 及这个数可以整除10 或者整除2和5
 * 边界条件0
 * 实际是统计质因子5的个数
 * 可以先把所有的质因子都列出来
 * 2肯定是多余5的，统计5，每个5都有配对的2，组成10
 *
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 *
 */
public class TrailingZeroes_172 {

    public static void main(String[] args) {
        TrailingZeroes_172 z = new TrailingZeroes_172();
        System.out.println(z.trailingZeroes(30));
        System.out.println(z.trailingZeroes1(30));
        System.out.println(20*19*18*17);
    }

    /**
     * 2 5
     * 10 2 5
     * 12 15 2 2 3 3 5
     * 20 2 2 5
     * 22 25   2 11 5 5
     *
     * 30 2 3 5
     *
     * */
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; i <= n; i++) {
            for (int j = i; (j % 5) ==0; j = j/5) {
                count ++;
            }
        }
        return count;
    }

    public int trailingZeroes1(int n) {
        int count = 0;
        while (n!=0){
            n = n/5;
            count += n;
        }
        return count;
    }
}
