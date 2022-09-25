package com.gzd.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * <p>
 * 思路：直接遍历，从首字符不是空格字符开始，遍历，遇到空格，计数器+1，
 *
 * @author guozhongdong
 */
public class CountSegments_434 {

    public static void main(String[] args) {
        String str = ". . . . . .      av,1213";
        CountSegments_434 segments434 = new CountSegments_434();
        System.out.println(segments434.countSegments(str));
        System.out.println(segments434.countSegments1(str));
    }

    public int countSegments(String s) {

        if (s == null || "".equals(s.trim())) {
            return 0;
        }

        int count = 0;
        s = s + " ";
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ' ') {
                str.append(s.charAt(i));
            } else {
                list.add(str.toString());
                str = new StringBuilder();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (!"".equals(list.get(i))){
                count++;
            }
        }
        System.out.println(list);


        return count;
    }

    /**
     * 优化 ，参考String 的split方法
     */
    public int countSegments1(String s) {

        if (s == null) {
            return 0;
        }

        int count = 0;
        // 有效字符的特征,前面肯定是一个空格
        // 边界值 第一个字符
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' '){
                count++;
            }
        }
        return count;
    }

}
