package com.gzd.leetcode.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘
 * 同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * 美式键盘 中：
 * <p>
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 示例 2：
 * <p>
 * 输入：words = ["omk"]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 * <p>
 * 思路：先把每一行的单词枚举出来
 * 遍历数字判断
 */
public class FindWords_500 {

    static List<Set<Character>> list = new ArrayList<>();

    static {
        char[] c1 = "qwertyuiop".toCharArray();
        char[] c2 = "asdfghjkl".toCharArray();
        char[] c3 = "zxcvbnm".toCharArray();
        Set<Character> set1 = new HashSet<>();
        for (int i = 0; i < c1.length; i++) {
            set1.add(c1[i]);
        }
        list.add(set1);
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < c2.length; i++) {
            set2.add(c2[i]);
        }
        list.add(set2);
        Set<Character> set3 = new HashSet<>();
        for (int i = 0; i < c3.length; i++) {
            set3.add(c3[i]);
            list.add(set3);
        }

    }

    public static void main(String[] args) {
        FindWords_500 words = new FindWords_500();
        String[] strs = {"Hello","Alaska","Dad","Peace"};
        String[] res = words.findWords(strs);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }


    public String[] findWords(String[] words) {

        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isMan(words[i])) {
                result.add(words[i]);
            }
        }
        String[] strs = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            strs[i] = result.get(i);
        }
        return strs;


    }

    private boolean isMan(String str) {

        char[] c1 = str.toCharArray();
        for (int i = 0; i < list.size(); i++) {
            Set<Character> s = list.get(i);
            boolean flag = false;
            for (int j = 0; j < c1.length; j++) {
                if (!s.contains(Character.toLowerCase(c1[j]))) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) {
                return true;
            }

        }
        return false;
    }
}
