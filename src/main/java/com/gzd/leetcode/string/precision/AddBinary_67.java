package com.gzd.leetcode.string.precision;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 * <p>
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 *
 * @author guozhongdong
 */
public class AddBinary_67 {

    public static void main(String[] args) {
        AddBinary_67 add = new AddBinary_67();

        System.out.println(2 % 1);
        System.out.println(1 % 1);

        System.out.println(add.addBinary1("11", "10"));
        //System.out.println(add.addBinary1("11", "1"));
        // 1110
        // 1011
//1        1001
    }

    /**
     * 用api超长度限制了，
     */
    public String addBinary(String a, String b) {

        long a1 = Long.parseLong(a, 2);
        long b2 = Long.parseLong(b, 2);
        return Long.toBinaryString(a1 + b2);
    }


    /**
     * 老老实实加吧
     */
    public String addBinary1(String a, String b) {


        int a1 = a.length() - 1;
        int b1 = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int jinzhi = 0;
        // 计算的核心
        /**
         * 1101
         *  111
         * 10100
         *
         * */
        while (a1 >= 0 || b1 >= 0 || jinzhi != 0) {
            int i = a1 >= 0 ? a.charAt(a1) - '0' : 0;
            int j = b1 >= 0 ? b.charAt(b1) - '0' : 0;
            int result = i + j + jinzhi;
            if (result == 2) {
                sb.append('0');
                jinzhi = 1;
            } else if (result == 1) {
                sb.append('1');
                jinzhi = 0;
            }else if (result == 3) {
                sb.append('1');
                jinzhi = 1;
            } else if (result == 0) {
                sb.append('0');
                jinzhi = 0;
            }
            a1--;
            b1--;
        }
        return sb.reverse().toString();
    }
}
