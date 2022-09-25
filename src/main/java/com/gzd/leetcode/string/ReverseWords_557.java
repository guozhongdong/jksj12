package com.gzd.leetcode.string;

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 * <p>
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 * <p>
 * 1 <= s.length <= 5 * 104
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 * 思路：结合统计单词的字数和翻转字符串
 *
 * 给的字符串，划掉了很多边界条件，直接遍历，找单词，然后翻转每个单子，空格不处理
 *
 * @author guozhongdong
 */
public class ReverseWords_557 {

    public static void main(String[] args) {
        String str = "God Ding";
        ReverseWords_557 words = new ReverseWords_557();
        System.out.println(words.reverseWords(str));
    }

    public String reverseWords(String s) {

        char[] ch = s.toCharArray();
        int n = ch.length;
        // 记录单词的起始位置和结束下标
        int count = 0;
        boolean flag = false;
        int i = 0;
        while (i < n){
            // 找到单词  i 是一个单词的开头
            if ((i == 0 || ch[i - 1] == ' ') && (ch[i] != ' ')) {
                count = i;
                flag = true;
            }
            // 如果有开头了,则计算单词的长度
            if (flag) {
                // 单词长度统计
                while (count < n && ch[count] != ' ') {
                    count++;
                }
                // 翻转
                reverse(ch, i, count - 1);
                // 将单词开头的下标转换为单词末尾的下标，
                i = count;
            }else {
                i++;
            }
            // 翻转一个单词后，标识符置为false
            flag = false;
        }

        return new String(ch);
    }

    //  双指针交换
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
