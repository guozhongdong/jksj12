package com.gzd.leetcode.bit;


/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
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
 * 示例 1：
 * <p>
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 * <p>
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 * <p>
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * <p>
 * 思路：参考171题
 * 171的公式
 * res = res * 26 + (char -'A' +1);
 * ZY = 701
 */
public class ConvertToTitle_168 {

    public static void main(String[] args) {
        ConvertToTitle_168 convert = new ConvertToTitle_168();
        System.out.println(convert.convertToTitle(2147483647));
        System.out.println(701 % 26);
        System.out.println(701 / 26);
        System.out.println(Character.toChars('A' + (701 % 26)));
    }

    public String convertToTitle(int columnNumber) {
        if (columnNumber == 1) {
            return "A";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            int c1 = columnNumber % 26;
            if (c1 == 0) {
                sb.append(Character.toChars('Z'));
                columnNumber = columnNumber / 26 - 1;
            } else {
                sb.append(Character.toChars('A' + c1 - 1));
                columnNumber = columnNumber / 26;
            }
        }

        return sb.reverse().toString();
    }
}
