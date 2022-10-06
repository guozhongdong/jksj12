package com.gzd.leetcode.bit;


/**
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * <p>
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 * <p>
 * 如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true​​​ 。否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 * 示例 2：
 * <p>
 * 输入：s = "110"
 * 输出：true
 * <p>
 * 理解题意，直接遍历，判断连续1的个数，如果大于2，则直接返回false，如果就一段连续1，则返回true
 */
public class CheckOnesSegment_1784 {

    public static void main(String[] args) {

        CheckOnesSegment_1784 check = new CheckOnesSegment_1784();
        System.out.println(check.checkOnesSegment("110"));

    }

    /**
     * 时间复杂度o(N)
     * 使用额外的几个变量
     */
    public boolean checkOnesSegment(String s) {


        int i = 0;
        // 1001
        int zong = 0;
        while (i < s.length()) {
            int j = i;
            int count = 0;
            while (j < s.length() && (s.charAt(j) - '0') == 1) {
                count = 1;
                j++;
            }
            if (j > i) {
                i = j;
            } else {
                i++;
            }

            zong += count;
        }
        return zong == 1;
    }
}
