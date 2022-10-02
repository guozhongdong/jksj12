package com.gzd.leetcode.bit;

/**
 *
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 *
 *  
 * 1100
 *
 * 1011
 * 0101
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
 * 先找最高位的1
 * 如果1在0-30为之间，可以说明它是正数，直接跟 全是1的数异或
 * 如果不在则特殊处理，
 *
 *
 * @author guozhongdong
 */
public class FindComplement_476 {

    public static void main(String[] args) {
        FindComplement_476 complement = new FindComplement_476();
        System.out.println(Integer.toBinaryString(0x7fffffff ^ 5));
        // 011
        // 000
        System.out.println(complement.findComplement(3));
    }

    public int findComplement(int num) {
        // 011 -> 110
        // 100 -> 1000 0111 ^ 0101 -> 0010
        int res = 0;
        for (int i = 1; i <= 30; i++) {
            if (num >= (1 << i) ){
                res = i ;
            }else {
                break;
            }
        }

        int mask = (res == 30 ? 0x7fffffff : (1 << (res+1)) -1);
        return num ^ mask;
    }


}
