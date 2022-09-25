package com.gzd.leetcode.string.count;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *  
 * <p>
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author guozhongdong
 */
public class IsAnagram_242 {

    public static void main(String[] args) {
        IsAnagram_242 isAnagram = new IsAnagram_242();
        String s1 = "abcd";
        String s2 = "bcda";
        System.out.println(isAnagram.isAnagram(s1, s2));
    }


    /**
     * 用数组计算频次
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            temp[c - 'a']++;
        }
        // 如果c2里有频次是0，则是不符合
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            temp[c - 'a']--;
            if (temp[c - 'a'] < 0){
                return false;
            }
        }
        return true;

    }

    /**
     * Hash表统计频次
     */
    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < c1.length; i++) {
            map.put(c1[i], map.getOrDefault(c1[i], 0) + 1);
        }
        // 如果c2里有频次是0，则是不符合
        for (int i = 0; i < c2.length; i++) {
            if (map.containsKey(c2[i])) {
                map.put(c2[i], map.get(c2[i]) - 1);
            }
            if (map.get(c2[i]) == null || map.get(c2[i]) < 0) {
                return false;
            }
        }
        return true;

    }

    public boolean isAnagram1(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;

    }
}
