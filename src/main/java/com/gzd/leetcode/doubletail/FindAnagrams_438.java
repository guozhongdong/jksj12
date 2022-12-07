package com.gzd.leetcode.doubletail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
 * 不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabac", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * <p>
 * 滑动窗口，窗口大小明确，然后比较窗口内的字符串和目标传是否满足异或，记录起始下标
 */
public class FindAnagrams_438 {

    public static void main(String[] args) {

        FindAnagrams_438 find = new FindAnagrams_438();
        System.out.println(find.findAnagrams(
                "eidbaooo",
                "ab"));

    }

    Map<Character, Integer> map = new HashMap<>();

    /**
     * 暴力解法超时
     */
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        // 先把目标串放到hash表中
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        // 再定义一个map存放窗口的大小
        Map<Character, Integer> window = new HashMap<>();
        // 窗口的左右边界
        int left = 0;
        int right = 0;
        int valid = p.length();
        // cbaebabac    abc
        while (right < s.length()) {

            if (map.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                if (window.get(s.charAt(right)) <= map.get(s.charAt(right))) {
                    valid--;
                }
            }
            while (valid == 0) {
                if (right - left + 1 == p.length()) {
                    list.add(left);
                }
                if (map.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    if (window.get(s.charAt(left)) < map.get(s.charAt(left))) {
                        valid++;
                    }
                }
                left++;
            }
            right++;

        }


        return list;
    }

    private boolean isYiHuo(String a) {
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map2.put(a.charAt(i), map2.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> en : map2.entrySet()) {
            if (!en.getValue().equals(map.get(en.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
