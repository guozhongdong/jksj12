package com.gzd.leetcode.string;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * <p>
 * 思路：中心拓展法
 *
 * @author guozhongdong
 */
public class LongestPalindrome_5 {

    public static void main(String[] args) {
        LongestPalindrome_5 palindrome = new LongestPalindrome_5();
        System.out.println(palindrome.longestPalindrome("babad"));
    }

    /**
     * 中心拓展法
     * 区分奇偶
     */
    public String longestPalindrome(String s) {

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            int m1 = isHuiWen(s, i, i );
            // 偶数
            int m2 = isHuiWen(s, i, i+1);
            // 取最大值
            int max = Math.max(m1, m2);
            // 计算下标--没仔细想
            if (max > right - left) {
                left = i - (max - 1) / 2;
                right = i + max / 2;
            }
        }
        return s.substring(left, right+1);

    }


    // 返回 回文的长度
    // aba
    public int isHuiWen(String str, int left, int right) {

        int n = str.length();
        // 定义边界值，往两边找
        while (left >= 0 && right < n) {
            if (str.charAt(left) == str.charAt(right)) {
                left--;
                right++;

            } else {
                break;
            }
        }
        return right - left - 1;
    }


    /**
     * 动态规划
     * 区分奇偶
     */
    public String longestPalindrome1(String s) {

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            int m1 = isHuiWen(s, i, i );
            // 偶数
            int m2 = isHuiWen(s, i, i+1);
            // 取最大值
            int max = Math.max(m1, m2);
            // 计算下标--没仔细想
            if (max > right - left) {
                left = i - (max - 1) / 2;
                right = i + max / 2;
            }
        }
        return s.substring(left, right+1);

    }



}
