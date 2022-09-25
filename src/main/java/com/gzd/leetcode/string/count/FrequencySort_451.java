package com.gzd.leetcode.string.count;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。
 * 一个字符出现的 频率 是它出现在字符串中的次数。
 * <p>
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * 思路1：
 * hash表记录字符出现的次数
 * 数组对应次数
 *
 * @author guozhongdong
 */
public class FrequencySort_451 {

    public static void main(String[] args) {
        String str = "tee";
        FrequencySort_451 sort = new FrequencySort_451();
        System.out.println(sort.frequencySort(str));
    }

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 按次数排序，生成一个新的字符串列表
        List<Character> list = new ArrayList<>(map.keySet());
        // 排序后的字符
        Collections.sort(list, (a,b)-> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < list.size(); k++) {
            char ct = list.get(k);
            int fen = map.get(ct);
            for (int i = 0; i < fen; i++) {
                sb.append(ct);
            }

        }
        return sb.toString();
    }
    // 桶计数排序
}
