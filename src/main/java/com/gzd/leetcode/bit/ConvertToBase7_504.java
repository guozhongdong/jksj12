package com.gzd.leetcode.bit;

/**
 *
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: num = -7
 * 输出: "-10"
 *
 * 十进制转7进制，
 * 1、直接用api
 *
 *
 * @author guozhongdong
 * @date 2022/9/28 22:27
 */
public class ConvertToBase7_504 {

    public static void main(String[] args) {
        ConvertToBase7_504 base7 = new ConvertToBase7_504();

        System.out.println(base7.convertToBase7(-10));
        System.out.println(base7.convertToBase71(-10));
    }

    public String convertToBase7(int num) {

        return Integer.toString(num,7);
    }
    /**
     * 辗转相除法
     * 除7
     * 20
     * 二进制： 10100
     * 七进制： 26
     * 八进制： 24
     * 十六进制：A
     */
    public String convertToBase71(int num) {
        if (num ==0){
            return "0";
        }
        boolean flag = false;
        if (num < 0 ){
            flag = true;
        }
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            sb.append(num % 7);
            num = num/7;
        }
        if (flag){
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
