package com.gzd.leetcode.string.change;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，
 * 使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，
 * 尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，
 * 则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 注意:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *  
 *
 * 示例 1:
 *
 * 输入: words = ["This", "is", "an", "example", "of", "text",
 * "justification."], maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:words = ["What","must","be","acknowledgment","shall","be"],
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:words = ["Science","is","what","we","understand","well","enough","to",
 * "explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *  
 *
 * 提示:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] 由小写英文字母和符号组成
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 *
 * 遍历数组
 *
 * @author guozhongdong
 */
public class FullJustify_68 {

    public static void main(String[] args) {

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list= new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        StringBuilder sb1 = new StringBuilder();
        int danci = 0;
        for (int i = 0; i < words.length; i++) {
            // 记录每一行新单词个数

            if (sb.length() <= maxWidth){
                sb1.append(words[i]);
                danci++;
                sb1.append(' ');
            }else {
                // 此时sb1 满足了单词，剩下的就是加空格
                // 多余的空格 duo = maxWidth - sb.length();
                int duo = maxWidth - sb.length()-1;
                // 如何均匀分配
                // 剩下的空格刚好够分
                int mei = 0;
                if (duo % (danci -1) == 0){
                    mei= duo / danci;
                }


                sb1 = new StringBuilder();
            }



        }

        return list;
    }
}
