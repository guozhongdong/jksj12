package com.gzd.leetcode.string.precision;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *  
 * <p>
 * 两个数很大，用不了api
 * 直接取字符串相加，
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 *
 * @author guozhongdong
 */
public class AddStrings_415 {

    public static void main(String[] args) {
        AddStrings_415 addStrings = new AddStrings_415();
        System.out.println(addStrings.addStrings("99", "999"));

    }


    /**
     * 双指针，
     * <p>
     * 用额外变量记录进位
     * 位数不同的补齐0
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


    public String addStrings1(String num1, String num2) {

        int a1 = num1.length() - 1;
        int b1 = num2.length() - 1;
        int jinzhi = 0;
        StringBuilder sb = new StringBuilder();
        while (a1 >= 0 && b1 >= 0) {
            int n1 = Character.digit(num1.charAt(a1), 10);
            int n2 = Character.digit(num2.charAt(b1), 10);
            int sum = n1 + n2;
            if ((sum + jinzhi) > 9) {
                sb.append(((sum + jinzhi) % 10));
                jinzhi = 1;
            } else {
                sb.append(sum + jinzhi);
                jinzhi = 0;
            }
            a1--;
            b1--;
        }

        while (a1 >= 0) {
            int s1 = Character.digit(num1.charAt(a1), 10);
            if (jinzhi == 1) {

                if (s1 + jinzhi > 9) {
                    sb.append(((s1 + jinzhi) % 10));
                    jinzhi = 1;
                } else {
                    sb.append((s1 + jinzhi));
                    jinzhi = 0;
                }

            } else {
                sb.append(s1);
            }

            a1--;
        }
        while (b1 >= 0) {
            int s1 = Character.digit(num2.charAt(b1), 10);
            if (jinzhi == 1) {

                if (s1 + jinzhi > 9) {
                    sb.append(((s1 + jinzhi) % 10));
                    jinzhi = 1;
                } else {
                    sb.append((s1 + jinzhi));
                    jinzhi = 0;
                }

            } else {
                sb.append(s1);
            }
            b1--;
        }
        if (jinzhi != 0) {
            sb.append(jinzhi);
        }
        return sb.reverse().toString();

    }
}
