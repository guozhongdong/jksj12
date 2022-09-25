package com.gzd.leetcode.string.count;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 * <p>
 * 初步思路：hash表
 *
 * @author guozhongdong
 */
public class CanConstruct_383 {

    public static void main(String[] args) {
        System.out.println(new CanConstruct_383().canConstruct("abc", "abcd"));
    }


    /**
     * 字符统计
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        if (magazine.length() < ransomNote.length()){
            return false;
        }
        char[] ch1 = ransomNote.toCharArray();
        char[] ch2 = magazine.toCharArray();

        char[] c1 = new char[26];
        char[] c2 = new char[26];
        for (int i = 0; i < ch2.length; i++) {
            char c = ch2[i];
            c2[c - 'a']++;
        }
        // 判断目标字符串里的统计数目是不是比 c2的大，大肯定不满足
        for (int i = 0; i < ch1.length; i++) {
            char c = ch1[i];
            c1[c - 'a']++;
            if (c1[c - 'a'] > c2[c - 'a']){
                return false;
            }
        }
        return true;
    }

    /**
     * 排序，分别遍历比较
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        char[] ch1 = ransomNote.toCharArray();
        char[] ch2 = magazine.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        int j = 0;

        for (int i = 0; i < ch1.length; i++) {
            boolean flag = false;
            for (int k = j; k < ch2.length; k++) {
                if (ch1[i] == ch2[k]){
                    j= k+1 ;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return false;
            }


        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        Map<Character, Integer> set = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            set.put(magazine.charAt(i), set.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        int i = 0;
        for (; i < ransomNote.length(); i++) {
            if (set.containsKey(ransomNote.charAt(i))) {
                char ch = ransomNote.charAt(i);
                Integer val = set.get(ch);
                if (val > 1) {
                    set.put(ch, set.get(ch) - 1);
                } else {
                    set.remove(ch);
                }
            } else {
                return false;
            }

        }
        return true;
    }
}
