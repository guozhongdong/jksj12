package com.gzd.leetcode.string;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still 2joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 * <p>
 * 参考434题统计单词数量，这次需要在此基础上计算每个单词的长度，并取最大值
 *
 * @author guozhongdong
 */
public class LengthOfLastWord_58 {

    public static void main(String[] args) {
        LengthOfLastWord_58 lastWord = new LengthOfLastWord_58();
        String str = "luffy is still 2joyboy";
        System.out.println(lastWord.lengthOfLastWord(str));
        System.out.println(lastWord.lengthOfLastWord1(str));
    }


    /**
     * 此方法是计算了每个单词的长度，如果取最大长度，可以复用
     *
     */
    public int lengthOfLastWord(String s) {

        int max = 0;
        int wordLen = 0;
        boolean isWord = false;
        for (int i = 0; i < s.length(); i++) {
            // Hello World
            if (isWord && s.charAt(i) != ' ') {
                // 遍历字符，直到遇到空字符，则此时i就是单词的最后一个字符下标，减去第一个字符的小标，
                // 就是长度
                max =  i - wordLen + 1;
            } else {
                isWord = false;
            }
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                isWord = true;
                wordLen = i;
                max = 1;
            }

        }
        return max;
    }

    /**
     * 从后往前遍历
     * 遇到第一个单词，计算长度即可
     */
    public int lengthOfLastWord1(String s) {


        int count = 0;
        for (int i = s.length()-1; i >= 0 ; i--) {
            // Hello World
            if ((i == s.length() -1 || count == 0) && s.charAt(i) == ' '  ){
                continue;
            }
            if (s.charAt(i) != ' '){
                count++;
            }
            if (s.charAt(i) == ' '  ){
                break;
            }

        }
        return count;
    }
}
