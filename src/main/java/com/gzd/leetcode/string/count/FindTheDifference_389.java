package com.gzd.leetcode.string.count;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * 思路：题目提示的很明显，之多一个字符
 * 可以使用求和法，异或法，排序后比较
 *
 * @author guozhongdong
 */
public class FindTheDifference_389 {


    public static void main(String[] args) {
        String s = "ab";
        String t = "aab";

        FindTheDifference_389 difference = new FindTheDifference_389();
        System.out.println(difference.findTheDifference(s, t));

    }

    /**
     * 排序法
     * 排序法，第一个不同的
     */
    public char findTheDifference(String s, String t) {

        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]){
                return s2[i];
            }
        }

        return s2[s2.length-1];

    }

    /**
     * 异或法
     * 类似的是求和法
     */
    public char findTheDifference2(String s, String t) {
        char sumS = 0;
        for (int i = 0; i < s.length(); i++) {
            sumS ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            sumS ^= t.charAt(i);
        }
        return sumS;

    }

    public char findTheDifference1(String s, String t) {
        char sumS = 0;
        for (int i = 0; i < s.length(); i++) {
            sumS += s.charAt(i);
        }
        char sumT = 0;
        for (int i = 0; i < t.length(); i++) {
            sumT += t.charAt(i);
        }
        return (char) (sumT - sumS);

    }
}
