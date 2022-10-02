package com.gzd.leetcode.bit;

/**
 *
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 *  
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，
 * 并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *  
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *  
 *
 * 提示：
 *
 * 输入必须是长度为 32 的 二进制串 。
 *  
 *
 * 进阶：
 *
 * 如果多次调用这个函数，你将如何优化你的算法？
 *
 * 思路1: api法，直接转成二进制的字符串，遍历，统计次数
 * 思路2: 使用位运算
 * 将每一个为二进制位与1进行&运算，结果还是1的，那就coutt++;
 *
 * @author guozhongdong
 * @date 2022/9/30 18:12
 */
public class HammingWeight_191 {

    public static void main(String[] args) {

        HammingWeight_191 weight_191 = new HammingWeight_191();
        System.out.println(weight_191.hammingWeight(823));
        System.out.println(weight_191.hammingWeight1(823));
        System.out.println(weight_191.hammingWeight2(823));
    }


    public int hammingWeight2(int n) {

        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }


    public int hammingWeight1(int n) {

        int count = 0;
        for (int i = 0; i < 32; i++) {
            int zui = n &  1;
            if (zui == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int hammingWeight(int n) {

        String str = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1'){
                count++;
            }
        }

        return count;
    }
}
