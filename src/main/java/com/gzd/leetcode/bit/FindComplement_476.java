package com.gzd.leetcode.bit;

/**
 *
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 *
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 * 二进制取反
 *
 * @author guozhongdong
 */
public class FindComplement_476 {

    public static void main(String[] args) {
        FindComplement_476 complement = new FindComplement_476();
        System.out.println(Integer.toBinaryString(5 ^ 15));
        System.out.println(Integer.toBinaryString(complement.findComplement(5)));
    }

    public int findComplement(int num) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 101
            res = (num ^ 0);
            num = num >> 1;

        }
        return res;
    }


}
