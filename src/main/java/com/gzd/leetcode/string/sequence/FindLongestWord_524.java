package com.gzd.leetcode.string.sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，
 * 该字符串可以通过删除 s 中的某些字符得到。
 * <p>
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 * <p>
 * 1、先遍历数组，找出符合的字符串，参考392
 * <p>
 * 2、用hash表做统计，
 * 然后比较从hash表取最长的，如果取多个，则比较字母序
 *
 * @author guozhongdong
 * @date 2022/9/21 21:36
 */
public class FindLongestWord_524 {
    public static void main(String[] args) {
        FindLongestWord_524 word = new FindLongestWord_524();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        System.out.println(word.findLongestWord("abpcplea", dictionary));
    }

    /**
     * 优化1： 双指针
     * <p>
     * 一次与数组的字符串遍历，对比成功，记录字符串的长度，
     * 取最大值的那个，记录下来，跟下个符合的进行比较
     */
    public String findLongestWord(String s, List<String> dictionary) {

        String maxStr = "";

        for (int i = 0; i < dictionary.size(); i++) {

            int s1 = 0;
            int t1 = 0;
            //
            String t = dictionary.get(i);
            while (s1 < s.length() && t1 < t.length()) {
                if (s.charAt(s1) == t.charAt(t1)) {
                    t1++;
                }
                s1++;

            }
            // t1 等于数组的字符串长度，说明他是符合的，就判断是否是最长的
            // 第二个条件，判断他是不是最长的，且序列是小的
            if (t1 == t.length()) {
                if (t.length() > maxStr.length() || (t.length() == maxStr.length() && t.compareTo(maxStr) > 0)) {
                    maxStr = t;
                }

            }
        }
        return maxStr;
    }

    public String findLongestWord1(String s, List<String> dictionary) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dictionary.size(); i++) {
            String str = dictionary.get(i);
            if (isSubsequence(str, s)) {
                map.put(str, str.length());
            }
        }
        if (map.size() == 0) {
            return "";
        }
        // 将map表按值排序

        List<Map.Entry<String, Integer>> infoIds = new ArrayList<>(map.entrySet());

        //根据value排序
        infoIds.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
        int num1 = infoIds.get(0).getValue();
        List<String> fuhe = new ArrayList<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() == num1) {
                fuhe.add(m.getKey());
            }
        }
        if (fuhe.size() == 1) {
            return fuhe.get(0);
        }
        String str = fuhe.get(0);
        for (int f = 1; f < fuhe.size(); f++) {
            str = compare(str, fuhe.get(f));
        }
        return str;
    }

    public boolean isSubsequence(String s, String t) {

        int s1 = 0;
        int t1 = 0;
        while (s1 < s.length() && t1 < t.length()) {
            if (s.charAt(s1) == t.charAt(t1)) {
                s1++;
                t1++;
            } else {
                t1++;
            }
        }
        return s1 >= s.length();
    }

    public int isSubsequence2(String s, String t) {

        int s1 = 0;
        int t1 = 0;
        while (s1 < s.length() && t1 < t.length()) {
            if (s.charAt(s1) == t.charAt(t1)) {
                s1++;
                t1++;
            } else {
                t1++;
            }
        }
        if (s1 >= s.length()) {
            return s.length();
        }
        return -1;
    }

    /**
     * 按字母序排列
     */
    public String compare(String s, String t) {

        int s1 = 0;

        while (s1 < s.length()) {
            if (s.charAt(s1) == t.charAt(s1)) {
                s1++;
            } else if (s.charAt(s1) < t.charAt(s1)) {
                return s;
            } else {
                return t;
            }
        }
        return null;
    }
}
