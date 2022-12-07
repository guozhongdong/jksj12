package com.gzd.leetcode.doubletail;

/**
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 *
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 *
 * 输入：s = "abc"
 * 输出：false
 *
 * 思路：同最简单的判断回文
 * 额外定义一个变量a，左边和右边不同的时候，任意删除一个，变量a=1,继续往下判断是否相等，如果还不相等，并且变量a=1
 * 则直接返回false
 *
 *
 */
public class ValidPalindrome_680 {

    public static void main(String[] args) {
        ValidPalindrome_680 valid = new ValidPalindrome_680();
        String str = "lcupuufxooooxfuupucul";
        System.out.println(str.length());
        System.out.println(valid.validPalindrome(str));
    }

    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                int n = left;
                int n2 = right;
                return isHuiWen(++n,right,s) || isHuiWen(left,--n2,s);
            }else {
                left++;
                right--;
            }

        }
        return true;
    }


    private boolean isHuiWen(int left, int right, String s){

        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
