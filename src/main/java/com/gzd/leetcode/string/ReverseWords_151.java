package com.gzd.leetcode.string;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * <p>
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，
 * 请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 * <p>
 * 思路：
 * 判断单词的前缀通用套路
 * 字符串从后向前遍历，遇到一个单词往后增加一个空格
 *
 * @author guozhongdong
 */
public class ReverseWords_151 {

    public static void main(String[] args) {
        String str = "  hello world  ";
        ReverseWords_151 words = new ReverseWords_151();
        System.out.println(words.reverseWords(str));
    }

    public String reverseWords(String s) {

        // 替换首为和中间多余的空格
        StringBuilder sb = trimSpace(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);
        // 翻转单词

        reverseWords2(sb);

        return sb.toString();
    }

    private void reverseWords2(StringBuilder sb) {

        int start = 0;
        int end = 0;
        int n = sb.length() - 1;
        // Hello wordl wwla
        while (start < sb.length()) {

            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end - 1);
            start = end+1;
            end = start+end+1;
        }


    }

    private StringBuilder trimSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        // 去掉左半部分空格
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // hello   word;
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;

    }

    //  双指针交换
    private void reverse(StringBuilder str, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            char temp = str.charAt(right);
            str.setCharAt(right--, str.charAt(left));
            str.setCharAt(left++, temp);

        }

    }
}
