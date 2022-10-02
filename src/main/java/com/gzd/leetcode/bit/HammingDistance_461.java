package com.gzd.leetcode.bit;


/**
 *
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * 0011
 * 0001
 *
 * 输入：x = 3, y = 1
 * 输出：1
 *
 *
 * @author gzd
 */
public class HammingDistance_461 {

    public static void main(String[] args) {
        HammingDistance_461 distance = new HammingDistance_461();
        System.out.println(distance.hammingDistance(3, 1));
    }

    public int hammingDistance(int x, int y) {

        //直接对比二进制位
        int count = 0;
        while (x != 0 || y !=0){
            int res = x & 1;
            int res2 = y & 1;
            if ((res ^ res2) == 1){
                count ++;
            }
            // 100 & 011 = 000
            x = x >> 1;
            y = y >> 1;
        }
        return count;

    }
    /**
     * 使用内置函数
     */
    public int hammingDistance1(int x, int y) {
        // 统计1的个数
        return Integer.bitCount(x ^ y);

    }

    /**
     * 先做异或算，得到结果
     * 然后根据 n & (n-1) 可以与调最后一个1，计算1的个数
     */
    public int hammingDistance2(int x, int y) {
        // 统计1的个数
        return Integer.bitCount(x ^ y);

    }

}
