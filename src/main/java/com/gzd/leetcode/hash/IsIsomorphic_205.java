package com.gzd.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 *
 * 参考 290题，abba 和 dog bad bad dog
 * 使用两个hash表保存字符的对应关系
 * 边界条件：
 * 1、两个字符串的长度得相等
 * 2、包含非字母的其他ASCII码
 *
 * 关键点：不同的字符不能映射到同一个字符上
 * 即：如果a和b映射了，a就不能和c做映射
 *
 *
 *
 */
public class IsIsomorphic_205 {

    public static void main(String[] args) {
        IsIsomorphic_205 phic = new IsIsomorphic_205();
        System.out.println(phic.isIsomorphic("edd", "add"));
    }

    public boolean isIsomorphic(String s, String t) {

        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();

        // title paper
        for (int i = 0; i < s.length(); i++) {

            char t1 = s.charAt(i);
            char t2 = t.charAt(i);
            if ((map1.containsKey(t1) && map1.get(s.charAt(i)) != t2) || (map2.containsKey(t2) && map2.get(s.charAt(i)) != t1)){
                return false;
            }
            map1.put(t1,t2);
            map2.put(t2,t1);
        }
        return true;
    }
}
