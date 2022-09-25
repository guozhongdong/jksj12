package com.gzd.leetcode.string;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * @author guozhongdong
 */
public class ReverseStr_541 {

    public static void main(String[] args) {
        String str = "abcdefg";
        ReverseStr_541 reverseStr = new ReverseStr_541();
        System.out.println(reverseStr.reverseStr(str, 3));

    }

    /**
     * 1、节点1 到2k处 翻转前k个字符
     * 2、到2k处，
     */
    public String reverseStr(String s, int k) {
        int n = s.length();

        // bacdfegb
        // 计数点
        /*int count = 0;
        for (int i = 0; i < n; i++) {

            if (n < k) {
                s = reverse(s, 0, n - 1);
            }
            int sh = n - i - 1;
            // abcde
            if (sh >= k && sh <= 2 * k) {
                s = reverse(s, i, i + k - 1);
            }
            if (sh < k) {
                s = reverse(s, i - k, i - 1);
                break;
            }
        }
        //
        return s;*/
        return null;
    }

    /**
     * 关键是理解本题的核心诉求
     * 到2k节点，翻转前k个，
     * 2k是一个步骤，剩余的不足k的全部翻转，
     * 大于k小于等于2k的 翻转前k个，后面不动，
     * 后面这句话，可以映射到本身字符串都不足k，或者小于2k
     *
     * 总之前k个肯定得翻转，n < k 翻转 n
     * k<n<2k,翻转k，剩余的不动，不动可以通过步长来限制
     *
     * n>2k,遍历一次翻转了前k个， i的下标来到2k处，重复上面的判断
     *
     */
    public String reverseStr1(String s, int k) {

        char[] ch = s.toCharArray();
        int n = ch.length;
        for (int i = 0; i < ch.length; i += 2 * k) {
            // 不如k全部翻转，
            reverse(ch, i, Math.min(i + k, n) - 1);
        }
        //
        return String.valueOf(ch);
    }

    /*
     *
     * 反转指定位置的字符
     **/
    private void reverse(char[] str, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            char temp = str[right];
            str[right] = str[left];
            str[left] = temp;
            left++;
            right--;
        }

    }

}
