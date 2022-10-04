package com.gzd.leetcode.bit;


/**
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：1
 * <p>
 * 思路：
 * 100数 9 个一样的
 * 1000个数 18个一样的
 * 10000 个数 27 个一样的
 * <p>
 * 直接求相等，然后拿总数减去相等的
 * n代表的最后一个数一定是10的倍数
 * <p>
 * 以上思路错误，被示例无解，
 * <p>
 * 直接不同的个数，排列组合
 * n == 1 ,有10种选择，0-9
 * n == 2 ,数x的第一位有9种选择，后面一位去掉与它相等，还剩9位  9*9 = 81
 * 分两部分计算，一部分是n=1的值，一部分是n=2的值，
 * <p>
 * <p>
 * n == 3 ,同理，9*9*8 = 81 * 8= 648  + 前一位的不同的 + 91 = 739
 */
public class CountNumbersWithUniqueDigits_357 {

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits_357 digit = new CountNumbersWithUniqueDigits_357();
        System.out.println(digit.countNumbersWithUniqueDigits(3));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        // 直接从n==2 开始枚举，列出n==1时候的值 累计到后面
        int sum = 10;
        int cheng = 9;
        int k = 1;
        for (int i = 2; i <= n; i++) {
            cheng = cheng * (10 - k);
            k++;
            sum += cheng;
        }
        return sum;
    }
}
