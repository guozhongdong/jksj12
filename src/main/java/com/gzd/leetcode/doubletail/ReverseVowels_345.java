package com.gzd.leetcode.doubletail;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入：s = "leetcode"
 * 输出："leotcede"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由 可打印的 ASCII 字符组成
 *
 * 双指针，前后遍历 遇到元音字母就交换
 *
 */
public class ReverseVowels_345 {

    public static void main(String[] args) {
        ReverseVowels_345 reverse = new ReverseVowels_345();
        System.out.println(reverse.reverseVowels("aA"));
    }


    static Set<Character> set = new HashSet<>();

    static {
        set.add('a');
        set.add('o');
        set.add('e');
        set.add('i');
        set.add('u');
        set.add('A');
        set.add('O');
        set.add('E');
        set.add('I');
        set.add('U');
    }

    public String reverseVowels(String s) {


        int left = 0;
        int right = s.length()-1;

        char[] chars = s.toCharArray();

        while (left < right){
            char le = chars[left];
            char ri = chars[right];
            if (set.contains(le) && !set.contains(ri)){
                right--;
            }else if (!set.contains(le) && set.contains(ri)){
                left++;
            }else {
                if (set.contains(le) && set.contains(ri)){
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                }
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
