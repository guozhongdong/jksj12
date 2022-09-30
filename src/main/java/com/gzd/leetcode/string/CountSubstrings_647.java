package com.gzd.leetcode.string;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 *
 * @author guozhongdong
 */
public class CountSubstrings_647 {
    public static void main(String[] args) {
        CountSubstrings_647 countSubstrings = new CountSubstrings_647();
        //System.out.println(countSubstrings.countSubstrings("abc"));
        System.out.println(countSubstrings.countSubstrings("aaa"));
    }

    /**
     * 中心拓展法统计
     */
    public int countSubstrings(String s) {

        if (s.length() == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            int s1 = expendCenter(s, i, i);
            int s2 = expendCenter(s, i, i + 1);
            // 偶数
            sum = sum + s1 + s2;
        }
        return sum;
    }

    private int expendCenter(String s, int left, int right) {

        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
