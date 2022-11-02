package com.gzd.leetcode.greed;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 * <p>
 * 输入:s = "a"
 * 输入:1
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 2000
 * s 只由小写 和/或 大写英文字母组成
 * <p>
 * 遍历字符串记录，每个字符的个数，统计偶数个的或者是计数个的最数
 * aabb
 * aaabbb
 * <p>
 * 参考题解思路：
 * 因为回文串的形式如 abba 和 abcba
 * 要么有偶数个字符组成，要么多加一个奇数次的字符
 * <p>
 * 实际ans = 总字符数- 出现过奇数次字符的个数 +1
 */
public class LongestPalindrome_409 {

    public static void main(String[] args) {
        LongestPalindrome_409 palindrome = new LongestPalindrome_409();
        System.out.println(palindrome.longestPalindrome("bb"));
    }

    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        int even = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 == 0) {
                ans += value;
            } else if (value > 1) {
                ans += value - 1;
                even = 1;
            } else {
                even = 1;
            }
        }
        return ans + even;
    }

    public int longestPalindrome1(String s) {
        if (s.length() == 1) {
            return 1;
        }
        // 根据题意知道了字符的存储范围
        // 使用数组存储，比上面的hash表更节省空间
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        // 判断已统计的字符里，是否全部都是偶数个，ans > 0 ,就说明存在奇数个字符
        // 想法很好
        int ans = 0;
        // 统计偶数个字符的总长度
        for (int v : count) {
            if (v % 2 == 0) {
                ans += (v % 2);
            }
        }
        // ans最终统计的是出现奇数次的字符
        return ans == 0 ? s.length() : (s.length() - ans + 1);
    }
}
