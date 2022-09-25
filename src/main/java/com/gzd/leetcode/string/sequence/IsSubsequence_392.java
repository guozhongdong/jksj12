package com.gzd.leetcode.string.sequence;

/**
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，
 * 你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 *
 * 先来暴力解法，遍历两个字符串
 *
 * @author guozhongdong
 * @date 2022/9/21 12:42
 */
public class IsSubsequence_392 {

    public static void main(String[] args) {
        IsSubsequence_392 subsequence = new IsSubsequence_392();
        System.out.println(subsequence.isSubsequence("", "ahbgdc"));
    }

    /**
     * 暴力解法
     *
     */
    public boolean isSubsequence1(String s, String t) {

        if (s.length() == 0 && t.length() == 0){
            return true;
        }
        if (s.length() == 0 && t.length() > 0){
            return true;
        }
        if (t.length() == 0 && s.length() > 0){
            return false;
        }
        int j = 0;
        // "aaaaaa"
        //"bbaaaa"
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean flag = false;

            while (j < t.length()) {
                char c2 = t.charAt(j);

                if (c == c2){
                    flag = true;
                    j++;
                    break;
                }
                j++;

            }
            if (!flag){
                return false;
            }
        }

        return true;
    }


    /**
     * 优化1： 双指针法
     *
     */
    public boolean isSubsequence2(String s, String t) {

        int s1 = 0;
        int t1 = 0;
        while (s1 < s.length() && t1 < t.length()){
            if (s.charAt(s1) == t.charAt(t1)){
                s1++;
                t1++;
            }else {
                t1++;
            }
        }
        return s1 >= s.length();
    }

    /**
     * 优化2： 动态规划
     *
     */
    public boolean isSubsequence(String s, String t) {

        int s1 = 0;
        int t1 = 0;
        while (s1 < s.length() && t1 < t.length()){
            if (s.charAt(s1) == t.charAt(t1)){
                s1++;
                t1++;
            }else {
                t1++;
            }
        }
        return s1 >= s.length();
    }
}
