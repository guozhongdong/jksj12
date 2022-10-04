package com.gzd.leetcode.bit;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * <p>
 * 给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 示例 2：
 * <p>
 * 输入：num = 7
 * 输出：false
 * <p>
 * 思路：
 * 拆解正因子，就是能被目标数整除的数，然后求和
 * 直接遍历暴力拆解
 */
public class CheckPerfectNumber_507 {

    public static void main(String[] args) {
        CheckPerfectNumber_507 number = new CheckPerfectNumber_507();
        System.out.println(number.checkPerfectNumber(28));
        System.out.println(number.checkPerfectNumber1(28));
        System.out.println(number.checkPerfectNumber2(28));
    }

    /**
     * 执行用时：2175 ms, 在所有 Java 提交中击败了9.85%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了93.90%的用户
     * 通过测试用例：98 / 98
     *
     *  跟超时差不多，待优化
     */
    public boolean checkPerfectNumber(int num) {

        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    /**
     * 28
     * 1 2 4 7 14;
     * 执行用时: 400 ms
     * 内存消耗: 38.2 MB
     * */
    public boolean checkPerfectNumber1(int num) {
        if (num == 1){
            return false;
        }
        int sum = 1;
        int count = 2;
        int res = num;
        while (count < res){
            if (num % count == 0){
                sum += count + num/count;
                res = num/count;
            }
            count++;
        }
        return sum == num;
    }
    /**
     * 题解优化
     *
     * 关键点考虑的 枚举的值不超过 num开方，
     * 找到前一个因子，肯定能找找到后面的那个因子
     */
    public boolean checkPerfectNumber2(int num) {
        if (num == 1){
            return false;
        }
        int sum = 1;
        int count = 2;
        while (count * count <= num){
            if (num % count == 0){
                // 考虑d*d = num 的情况，只加一个数字即可
                sum += count ;
                if (count * count < num){
                    sum += num/count;
                }
            }
            count++;
        }
        return sum == num;
    }

}
