package com.gzd.leetcode.string.precision;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
 * 它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 *
 * @author guozhongdong
 */
public class Multiply_43 {

    public static void main(String[] args) {
        Multiply_43 multiply = new Multiply_43();
        System.out.println(Integer.toBinaryString(123));
        System.out.println(Integer.toBinaryString(456));
        System.out.println(Integer.toBinaryString(56088));

        System.out.println(multiply.multiply("9", "99"));

    }

    /**
     * 正常将乘数分别与被乘数相乘，并将结果累加
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        String res = "0";
        // 先从乘数开始
        // 123 456

        for (int i = n2; i >= 0; i--) {
            // 定义一个变量，记录进位
            StringBuilder sb = new StringBuilder();
            int add = 0;
            // 记录后面补0的个数,这个是核心点，得想到
            for (int j = n2; j > i; j--) {
                // 直接补0
                sb.append('0');
            }

            int a1 = num2.charAt(i) - '0';
            // 开始计算
            for (int j = n1; j >= 0; j--) {
                int b1 = num1.charAt(j) - '0';
                int product = a1 * b1 + add;
                sb.append(product % 10);
                add = product / 10;
            }
            if (add != 0){
                sb.append(add);
            }

            res = addStrings(res,sb.reverse().toString());

        }
        return res;
    }

    /**
     * 两个数相加
     */
    public String addStrings(String num1, String num2) {

        int a1 = num1.length() - 1;
        int b1 = num2.length() - 1;
        int jinzhi = 0;
        StringBuilder sb = new StringBuilder();
        while (a1 >= 0 || b1 >= 0 || jinzhi != 0) {
            // 取数字，不足的按0算
            int i = a1 >= 0 ? num1.charAt(a1) - '0' : 0;
            int j = b1 >= 0 ? num2.charAt(b1) - '0' : 0;
            int result = (i + j + jinzhi) % 10;
            sb.append(result);
            jinzhi = (i + j + jinzhi) / 10;

            a1--;
            b1--;

        }
        return sb.reverse().toString();

    }
}
