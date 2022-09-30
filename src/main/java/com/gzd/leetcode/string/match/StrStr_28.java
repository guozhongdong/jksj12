package com.gzd.leetcode.string.match;

/**
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * <p>
 * 解法1:暴力解法
 * 解法2:
 *
 * @author guozhongdong
 * @date 2022/9/26 21:00
 */
public class StrStr_28 {

    public static void main(String[] args) {
        StrStr_28 strStr = new StrStr_28();
        System.out.println(strStr.strStr("leetcode", "code"));
    }

    /**
     * 暴力解法
     */
    public int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int c1 = haystack.length();
        int c2 = needle.length();

        int n1 = 0;
        int n2 = 0;
        // leetcode leeto
        while (n1 < c1) {
            int count = n1;
            while (count < c1 ) {
                char ch1 = haystack.charAt(count);
                char ch2 = needle.charAt(n2);
                if (ch1 == ch2) {
                    count++;
                    n2++;
                    if (n2 == c2) {
                        return n1;
                    }
                } else {
                    n2 = 0;
                    break;
                }

            }
            n1++;
        }
        return -1;
    }

    /**
     * 优化2：
     */
    public int strStr2(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int c1 = haystack.length();
        int c2 = needle.length();

        int n1 = 0;
        int n2 = 0;
        // leetcode leeto
        while (n1 < c1) {
            int count = n1;
            while (count < c1 && n2 < c2) {
                char ch1 = haystack.charAt(count);
                char ch2 = needle.charAt(n2);
                if (ch1 == ch2) {
                    count++;
                    n2++;
                    if (n2 == c2) {
                        return n1;
                    }
                } else {
                    n2 = 0;
                    break;
                }

            }
            n1++;

        }

        return -1;
    }
}
