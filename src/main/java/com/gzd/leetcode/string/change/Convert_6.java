package com.gzd.leetcode.string.change;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *  
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 思路： 找出题中的规律
 * z字形变换，主要是行下标的转换
 * 用StringBuilder 记录行
 * n行，就n个StringBuilder
 *
 * 注意row的变化
 *
 *
 *
 *
 * @author guozhongdong
 *
 */
public class Convert_6 {

    public static void main(String[] args) {
        Convert_6 convert = new Convert_6();
        System.out.println(convert.convert("PAYPALISHIRING", 3));
        System.out.println(convert.convert1("PAYPALISHIRING", 3));
        System.out.println(convert.convert2("PAYPALISHIRING", 3));
    }

    /**
     * 直接构造法
     *
     */
    public String convert(String s, int numRows) {

        int n = s.length();
        int r = numRows;
        if (s.length() == 1 || r >= n){
            return s;
        }
        // 关键公式，找到周期点
        int t = 2*r-2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < n - i; j+= t) {
                sb.append(s.charAt(i+j));
                if (i > 0 && i < r-1 && j+t-i < n){
                    // !!!
                    sb.append(s.charAt(j+t-i));
                }
            }
        }

        return sb.toString();
    }

    /**
     * 二维数组法
     * 主要是能画矩阵图，计算每个Z字变换的周期和每个周期对应的列数
     * 从图中可观察
     *
     * // 周期，向下r个，想右上r-2
     * t = r+ (r-2)
     * 每个周期需要的列数
     * c = 1 + (r-2)
     *
     * // 总列数
     * c = (n/t) * r-1
     *
     *
     */
    public String convert2(String s, int numRows) {

        int n = s.length();
        int r = numRows;
        if (numRows == 1){
            return s;
        }
        // 定义周期，列数
        int t = 2*r-2;
        //（n+t-1)/t是向上取整的代替，n除以t最小余数是1，最大余数是t-1，
        // 故而1<=((n+t-1)-n)/t<2 @xuehai.xue 周期在本题中不会是奇数，t=2*r-2，
        // 你说的节省开辟列，好像不成立，你解释的整除把括号内容拆解，n/t余数舍去，
        // （t-1)/t余数岂不是也舍去了，如何做到向上取整？
        int c = (n+t-1)/t*(r-1);
        char[][] chars = new char[r][c];
        for (int i = 0,x=0,y=0; i < n; i++) {
            chars[x][y] = s.charAt(i);
            if (i%t < r-1){
                x++;
            }else {
                x--;
                y++;
            }
        }

        // 填满后遍历取数据
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (chars[i][j] != 0){
                    result.append(chars[i][j]);
                }

            }

        }
        return result.toString();
    }


    public String convert1(String s, int numRows) {

        if (numRows == 1){
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        // 初始化StrringBuilder数组
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        // 记录行信息
        int row = 0;
        int index = 0;
        int len = s.length();
        while (index < len){
            // 前面三行
            while (index < len && row < numRows){
                sbs[row].append(s.charAt(index++));
                row++;
            }
            if (index == len ){
                break;
            }
            // 转折点,行到底了需要往回找
            row = numRows-2;

            while (index < len && row >=0){
                sbs[row].append(s.charAt(index++));
                row--;
            }
            row += 2;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sbs.length; i++) {
            result.append(sbs[i]);
        }
        return result.toString();
    }
}
