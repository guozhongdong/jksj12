package com.gzd.leetcode.bit;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 *
 * @author guozhongdong
 */
public class IsPalindrome_9 {


    public static void main(String[] args) {
        IsPalindrome_9 palindrome = new IsPalindrome_9();
        System.out.println(123 & 10);
        System.out.println(palindrome.isPalindrome(10));
    }

    // 1221
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int n = x;
        int res = 0;

        // 翻转整数
        while (n != 0) {
            // 取尾部数字
            int digit = n % 10;
            res = res * 10 + digit;
            n = n/10;
        }
        if (res != x){
            return false;
        }

        return true;
    }


    /**
     * 根据题解优化，翻转一半的数字
     * 终止条件是元数字 小于 翻转后的数字
     * 分奇偶
     */
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 ==0 && x != 0)) {
            return false;
        }
        int res = 0;
        // 翻转整数
        while (x > res) {
            // 取尾部数字
            res = res * 10 + x % 10;
            x = x/10;
        }
        return x == res || x == res/10;
    }
}
