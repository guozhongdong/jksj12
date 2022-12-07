package com.gzd.leetcode.doubletail;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 * <p>
 * 窗口大小是s1的长度，在每个窗口周期内判断是否包含s1的子串
 */
public class CheckInclusion_567 {

    public boolean checkInclusion(String s1, String s2) {

        // aab  baa aba
        // 先统计s1的字符以及字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0;
        int right= 0;
        int valid = s1.length();
        Map<Character, Integer> window = new HashMap<>();
        while (right < s2.length()){
            if (map.containsKey(s2.charAt(right))){
                window.put(s2.charAt(right),window.getOrDefault(s2.charAt(right),0)+1);
                if (window.get(s2.charAt(right)) <= map.get(s2.charAt(right))){
                    valid--;
                }
            }
            //
            while (valid == 0){
                if (right - left +1 == s1.length()){
                    return true;
                }
                // 开始向左移动窗口
                if (map.containsKey(s2.charAt(left))){
                    window.put(s2.charAt(left),window.get(s2.charAt(left))-1);
                    if (window.get(s2.charAt(left)) < map.get(s2.charAt(left))){
                        valid++;
                    }
                }
                left++;

            }
            right++;
        }

        return false;
    }

    public static void main(String[] args) {
        CheckInclusion_567 inclusion = new CheckInclusion_567();
        System.out.println(inclusion.checkInclusion("ab", "eidboaoo"));
    }


}
