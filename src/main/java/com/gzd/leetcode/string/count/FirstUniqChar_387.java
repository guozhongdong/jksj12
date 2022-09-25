package com.gzd.leetcode.string.count;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 * <p>
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: s = "aabb"
 * 输出: -1
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 只包含小写字母
 *
 * @author guozhongdong
 */
public class FirstUniqChar_387 {

    public static void main(String[] args) {

        String str = "leetcode";
        FirstUniqChar_387 uniqChar = new FirstUniqChar_387();

        System.out.println(uniqChar.firstUniqChar(str));
    }


    /**
     * 利用字符串的api方法
     */
    public int firstUniqChar(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.lastIndexOf(c) == s.indexOf(c)) {
                return i;
            }

        }
        return -1;
    }

    /**
     * 优化2，map存索引
     */
    public int firstUniqChar2(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }

        }
        return -1;
    }

    public int firstUniqChar1(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        Map<Character, Integer> map1 = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map1.put(s.charAt(i), i);
        }
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            if (en.getValue() == 1) {
                return map1.get(en.getKey());

            }
        }
        return -1;
    }
}
