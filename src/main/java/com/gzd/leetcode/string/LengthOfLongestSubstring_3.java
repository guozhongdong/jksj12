package com.gzd.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 *
 * 思路：滑动串口加hash表
 *
 *
 * @author guozhongdong
 * @date 2022/9/7 9:01
 */
public class LengthOfLongestSubstring_3 {
    public static void main(String[] args) {
        String str ="pwwkebw";

        LengthOfLongestSubstring_3 substring3 = new LengthOfLongestSubstring_3();
        System.out.println(substring3.lengthOfLongestSubstring(str));
    }

    /***
     * abcabcbb
     **/
    public int lengthOfLongestSubstring(String s) {

        if (s == null){
            return -1;
        }
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {

            // 如果发现容器中了，说明重复了，需要删除重复的元素，从左开始，左指针相应加+1；
            while (set.contains(s.charAt(i))){
                set.remove(s.charAt(start));
                start++;

            }
            set.add(s.charAt(i));
            maxLen = Math.max(maxLen,end-start+1);
            end++;
        }

        return maxLen;
    }
}
