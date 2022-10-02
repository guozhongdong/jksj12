package com.gzd.leetcode.bit;

import javax.xml.stream.FactoryConfigurationError;

/**
 *
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：
 * 换句话说，就是二进制表示中相邻两位的数字永不相同。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * 示例 3：
 *
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 *  
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 *
 * 定义一个变量boolean
 * 碰到1变true，碰到0变false
 *
 *
 *
 * @author guozhongdong
 * @date 2022/10/1 13:18
 */
public class HasAlternatingBits_693 {

    public static void main(String[] args) {

        HasAlternatingBits_693 bits = new HasAlternatingBits_693();
        System.out.println(bits.hasAlternatingBits(5));

    }

    /**
     * 取模求余，与前一个数比较是否相等
     */
    public boolean hasAlternatingBits(int n) {
        // 1010
        // 0011
        int pre = 3;
        while (n != 0){
           int num = n % 2;
           if (pre == num ){
               return false;
           }
           pre = num;
           n = n/2;

        }
        return true;
    }

    /**
     *
     * 5
     * 101 -> 010  101 ^ 010 = 111 + 1 = 1000 & 111 = 0
     * 010
     *
     * 011 -> 001 011^001 = 010 + 1 = 011 & 010 ==010
     *
     *
     * 100
     * n & (n+1)
     *
     * 这个思路很妙，将n 右移一位，然后跟原数异或，如果n是交替的，
     * 则异或的结果肯定全是1 ，
     * 然后加1 ，高位是1低位是1，与上异或的结果，结果就是0
     */
    public boolean hasAlternatingBits1(int n) {
        // 101 ^ 010 = 111
        // 0011
        int a = n ^ (n >> 1);
        return (a & (a+1)) == 1;
    }

}
