package com.gzd.leetcode.string.digit;

/**
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 * <p>
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，
 * 返回表示它们乘积的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，
 * 你需要将它转换为 0+2i 的形式。
 * 示例 2：
 * <p>
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，
 * 你需要将它转换为 0+-2i 的形式。
 *  
 * <p>
 * 提示：
 * <p>
 * num1 和 num2 都是有效的复数表示。
 *
 * @author guozhongdong
 */
public class ComplexNumberMultiply_537 {


    public static void main(String[] args) {
        ComplexNumberMultiply_537 multiply = new ComplexNumberMultiply_537();
        System.out.println(multiply.complexNumberMultiply("1+-1i", "1+-1i"));
    }

    public String complexNumberMultiply(String num1, String num2) {

        // 转换为数字，
        String[] s1 = num1.split("\\+");
        String[] s2 = num2.split("\\+");

        // 实
        int shi1 = Integer.parseInt(s1[0]) * Integer.parseInt(s2[0]);
        // 虚数字部分
        String xuStr1 = s1[1];
        String xuStr2 = s2[1];
        String xuS1 = xuStr1.substring(0, xuStr1.length() - 1);
        String xuS2 = xuStr2.substring(0, xuStr2.length() - 1);

        int shi2 = -(Integer.parseInt(xuS1) * Integer.parseInt(xuS2));
        // 虚i部分
        String xuI = ((Integer.parseInt(s1[0]) * Integer.parseInt(xuS2)) +
                (Integer.parseInt(s2[0]) * Integer.parseInt(xuS1))) + "i";

        // 计算值

        //拼接结果字符串

        return (shi1+shi2)+"+"+xuI;
    }


}
