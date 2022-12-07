package com.gzd.leetcode.doubletail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * <p>
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 
 * 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AAAAAACCCCCAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 105
 * s[i]=='A'、'C'、'G' or 'T'
 * <p>
 * 定义两个指针，区间是10，往后遍历，
 * 使用String的api方法
 */
public class FindRepeatedDnaSequences_187 {

    public static void main(String[] args) {

        FindRepeatedDnaSequences_187 sequences = new FindRepeatedDnaSequences_187();
        System.out.println(sequences.findRepeatedDnaSequences("AAAAAACCCCCAAAACCCCCCAAAAAGGGTTT"));

    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        // hash表也想到了，就是没敢用
        // hash记录次数，当有超过两次的串，则添加到结果集中
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) == 2) {
                list.add(str);
            }
        }
        return list;

    }

    /**
     * 滑动串口
     */
    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        // hash表也想到了，就是没敢用
        // hash记录次数，当有超过两次的串，则添加到结果集中
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) == 2) {
                list.add(str);
            }
        }
        return list;

    }
}
