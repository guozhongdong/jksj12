package com.gzd.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，
 * list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 *  
 * <p>
 * 提示:
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30 
 * list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。
 * list1 的所有字符串都是 唯一 的。
 * list2 中的所有字符串都是 唯一 的。
 * <p>
 * 思路：hash表保存字符串
 * 遍历两次
 */
public class FindRestaurant_599 {

    public static void main(String[] args) {

    }

    /*
     * Hash表解法，可优化
     *
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> set = new HashMap<>();
        Map<String, Integer> set1 = new HashMap<>();


        for (int i = 0; i < list1.length; i++) {
            set.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        // list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
        for (int i = 0; i < list2.length; i++) {
            if (set.containsKey(list2[i])) {
                min = Math.min(min, set.get(list2[i]) + i);
                set1.put(list2[i], set.get(list2[i]) + i);
            }
        }
        Set<String> set2 = new HashSet<>();
        for (Map.Entry<String, Integer> entry : set1.entrySet()) {
            if (entry.getValue() == min) {
                set2.add(entry.getKey());
            }
        }
        String[] res = new String[set2.size()];
        int i = 0;
        for (String s : set2) {
            res[i++] = s;
        }
        return res;
    }

    public String[] findRestaurant1(String[] list1, String[] list2) {


        Map<String, Integer> set = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            set.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        // list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
        for (int i = 0; i < list2.length; i++) {
            if (set.containsKey(list2[i])) {
                if ((set.get(list2[i]) + i) < min) {
                    res.clear();
                    res.add(list2[i]);
                    min = set.get(list2[i]) + i;
                }else if ((set.get(list2[i]) + i) == min) {
                    res.add(list2[i]);
                }else {
                    break;
                }

            }
        }
        return res.toArray(new String[res.size()]);
    }

}
