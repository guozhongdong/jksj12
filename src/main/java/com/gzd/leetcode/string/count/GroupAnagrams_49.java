package com.gzd.leetcode.string.count;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * @author guozhongdong
 */
public class GroupAnagrams_49 {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams_49 anagrams = new GroupAnagrams_49();
        System.out.println(anagrams.groupAnagrams(strs));
    }

    /**
     * hash法，value是异或单词的列表
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            result.add(list);
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            char[] c1 = strs[i].toCharArray();
            Arrays.sort(c1);
            String newStr = new String(c1);
            if (map.containsKey(newStr)) {
                List<String> temp = map.get(newStr);
                temp.add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(newStr, list);
            }

        }
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            result.add(list);
            return result;
        }
        for (int i = 0; i < strs.length; i++) {

            if (strs[i] != null) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (strs[j] != null && isAnagram(strs[i], strs[j])) {
                        list.add(strs[j]);
                        strs[j] = null;
                    }
                }
                result.add(list);
            }

        }

        return result;
    }


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
            if (temp[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}
