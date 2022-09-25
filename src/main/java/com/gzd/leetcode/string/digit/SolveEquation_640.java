package com.gzd.leetcode.string.digit;

/**
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，
 * 变量 x 和其对应系数。
 * <p>
 * 如果方程没有解或存在的解不为整数，请返回 "No solution" 。
 * 如果方程有无限解，则返回 “Infinite solutions” 。
 * <p>
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 * <p>
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 * <p>
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 *  
 * <p>
 * 提示:
 * <p>
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='. 
 * 方程由绝对值在 [0, 100]  范围内且无任何前导零的整数和变量 'x' 组成。
 * <p>
 * 计算左右x的系数和其他整数的值，移项
 * 考虑边界值，x=x 的情况，左右x相等，则无解
 *
 * @author guozhongdong
 */
public class SolveEquation_640 {

    public static void main(String[] args) {
        SolveEquation_640 solve = new SolveEquation_640();
        //System.out.println("x".substring(0,"x".length()-1));
        System.out.println(solve.solveEquation("2+2-x+x+3x=x+2x-x+x+4"));
    }

    public String solveEquation(String equation) {

        int leftX = 0;
        int rightX = 0;
        int left = 0;
        int right = 0;

        equation = equation.replace("-", "+-");

        String[] qua = equation.split("=");

        // 左边分割+号
        String[] leftStr = qua[0].split("\\+");
        for (int i = 0; i < leftStr.length; i++) {
            String s = leftStr[i];
            // x+5+-3+x=6+x+-2
            // x, 5 -3,x,6,x,-2
            if (s.contains("x")) {
                if (s.equals("x")) {
                    leftX += 1;
                } else if (s.equals("-x")){
                    leftX -= 1;
                }
                    else {
                    leftX += Integer.parseInt(s.substring(0, s.length() - 1));
                }
            } else {
                if (s.equals("")){
                    left+=0;
                }else{
                    left += Integer.parseInt(s);
                }

            }
        }
        String[] righttStr = qua[1].split("\\+");

        for (int i = 0; i < righttStr.length; i++) {
            String s = righttStr[i];
            // x+5+-3+x=6+x+-2
            // x, 5 -3,x,6,x,-2
            if (s.contains("x")) {
                if (s.equals("x")) {
                    rightX += 1;
                }  else if (s.equals("-x")){
                    rightX -= 1;
                }else {
                    rightX += Integer.parseInt(s.substring(0, s.length() - 1));
                }
            } else {
                if (s.equals("")){
                    right+=0;
                }else{
                    right += Integer.parseInt(s);
                }

            }
        }
        // 移，计算x的值
        if (leftX == rightX) {
            if (left != 0 || right!=0){
                if (left - right == 0){
                    return "Infinite solutions";
                }else {
                    return "No solution";
                }


            }else {
                return "Infinite solutions";
            }

        }
        leftX = leftX - rightX;
        left = right - left;
        if (leftX == 1) {
            return "x=" + left;
        } else {
            if ((left % leftX != 0)) {
                return "No solution";
            } else {
                return "x=" + (left / leftX);
            }

        }
    }
}
