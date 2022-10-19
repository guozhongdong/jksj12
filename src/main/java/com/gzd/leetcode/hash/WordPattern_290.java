package com.gzd.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 
 * s 中的每个非空单词之间存在着双向连接的对应规律。
 *
 *  
 *
 * 示例1:
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 *  
 *
 * 提示:
 *
 * 1 <= pattern.length <= 300
 * pattern 只包含小写英文字母
 * 1 <= s.length <= 3000
 * s 只包含小写英文字母和 ' '
 * s 不包含 任何前导或尾随对空格
 * s 中每个单词都被 单个空格 分隔
 *
 * 思路：这里如何寻找pattern 里规律
 * 使用hash表存储字符与串的对应关系
 * 保存串与字符的对应关系
 *
 * 模式串与字符串，肯定是对应的，长度不对应的肯定返回false
 *
 *
 */
public class WordPattern_290 {

    public static void main(String[] args) {
        WordPattern_290 pattern = new WordPattern_290();
        System.out.println(pattern.wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
                "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"));

    }

    public boolean wordPattern(String pattern, String s) {

        String[] strs = s.split(" ");
        // key 可能是模式的字符，也可以是目标串的一个单词
        Map<Object,Integer> map = new HashMap<>();
        if (pattern.length() != strs.length){
            return false;
        }
        /**
         * 这个我觉得很经典，直接拿put的返回值进行判断
         * r如果字符和串，都没有在map里保存过，put完，返回null
         * 如果都保存过相同的key，在返回原value值，这里判断下原value是不是对应的，
         * 也就是字符和串的顺序是不是对的
         *
         *
         */
        for (Integer i = 0; i < strs.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(strs[i], i)){
                return false;
            }

        }

        return true;
    }
}
