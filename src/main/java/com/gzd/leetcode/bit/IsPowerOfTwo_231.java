package com.gzd.leetcode.bit;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，
 * 返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 * <p>
 * 输入：n = 3
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：n = 4
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：n = 5
 * 输出：false
 *  
 * 思路：
 * <p>
 * 1、边界情况1、负数
 * 2、奇数不用考虑
 * 3、偶数辗转相除法，有余数则不行
 *
 * @author guozhongdong
 * @date 2022/9/28 21:10
 */
public class IsPowerOfTwo_231 {

    public static void main(String[] args) {
        IsPowerOfTwo_231 ofTwo = new IsPowerOfTwo_231();
        System.out.println(ofTwo.isPowerOfTwo(256));
        System.out.println(ofTwo.isPowerOfTwo1(256));
        System.out.println(ofTwo.isPowerOfTwo2(256));

        System.out.println(255 & -255);
    }

    /**
     * 暴力解法
     */
    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        while (n != 0) {
            if (n % 2 != 0) {
                return false;
            }
            if (n == 2) {
                return true;
            }
            n = n / 2;
        }


        return true;
    }

    /**
     * 利用二进制的位运算
     * 应为要满足是2的幂次方，二进制位肯定是只有一个1
     * 如
     * 1000 它的减一位是 0111
     * 两者相与，全为0 ，则n是2的幂次方
     */
    public boolean isPowerOfTwo1(int n) {

        return n > 0 && (n & (n - 1)) == 0;
    }


    /**
     * 利用二进制的补码机制
     * 先不考虑最高位的符号为
     * 如-8 等于原码 取反+1  1000 取反  0111 +1 = 1000
     * -16 源码 10000 取反01111 +1 = 10000
     * -7 源码0111 +1 = 1000 ，取反0111
     * 1000 它的减一位是 0111
     *
     */
    public boolean isPowerOfTwo2(int n) {

        return n > 0 && (n & (-n)) == n;
    }
}
