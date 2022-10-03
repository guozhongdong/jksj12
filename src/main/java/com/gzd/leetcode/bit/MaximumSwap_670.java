package com.gzd.leetcode.bit;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 * <p>
 * 给定数字的范围是 [0, 108]
 * <p>
 * 思路：咋一看是比较高位的数字，如果地位的数字大于高位的数字，则直接交换位置
 * 按这个思路，不像中等题
 */
public class MaximumSwap_670 {

    public static void main(String[] args) {
        MaximumSwap_670 swap = new MaximumSwap_670();
        System.out.println(swap.maximumSwap(88368));
    }

    public int maximumSwap(int num) {

        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {

            int max = chars[i];
            int biao = i+1;
            for (int j = i+1; j < chars.length ; j++) {
                if (chars[j] >= max){
                    biao = j;
                    max = chars[j];
                }

            }
            if (max > chars[i]){
                int temp = chars[biao];
                chars[biao] = chars[i];
                chars[i] = (char) temp;
                break;
            }

        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
