package com.gzd.leetcode.bit;


import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * 简单题
 * 先把每个字母对应的数值，枚举出来
 * 计算列的长度，前面的是基数，如果是ZB
 * 说明已经经历了 26个Z,即26 * 26
 */
public class TitleToNumber_171 {


    public static void main(String[] args) {
        TitleToNumber_171 number = new TitleToNumber_171();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(number.titleToNumber("AB"));
    }

    public int titleToNumber(String columnTitle) {

        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            sum = sum * 26 + ((c - 'A') +1);
        }

        return  sum;
    }
}
