package com.gzd.leetcode.string.count;

/**
 *
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 *
 * 输入：s = "fviefuro"
 * 输出："45"
 *
 * 暴力枚举。列出9个数字的单词
 *
 * @author guozhongdong
 *
 */
public class OriginalDigits_423 {

    public static void main(String[] args) {
        String str = "fviefuro";
        OriginalDigits_423 originalDigits = new OriginalDigits_423();
        System.out.println(originalDigits.originalDigits(str));

    }

    public String originalDigits(String s) {

        String[] strs = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs.length; i++) {
            String s1 = strs[i];
            if (pipei(s1,s) > 0){
                sb.append(i);
            }
        }

        return sb.toString();

    }

    private int pipei(String s1, String s) {

        char[] ch2 = s.toCharArray();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                char c2 = s.charAt(j);
                if (c1 == c2){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                return 1;
            }
        }
        return 1;
    }
}
