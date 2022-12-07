package com.gzd.leetcode.doubletail;

/**
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * <p>
 * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 * <p>
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅由大写英文字母组成
 * 0 <= k <= s.length
 * 通过次数80,148提交次数147,195
 * <p>
 * 滑动窗口，先判定是否
 * 双指针+滑动窗口
 *
 * 经典题
 */
public class CharacterReplacement_424 {


    public static void main(String[] args) {

        CharacterReplacement_424 replacement = new CharacterReplacement_424();
        replacement.characterReplacement("BBCAADD", 2);

    }

    public int characterReplacement(String s, int k) {

        int n = s.length();
        if (n < k) {
            return n;
        }
        // 定义一个数组，记录出现的频次
        int[] num = new int[26];
        // 定义两个指针
        int left = 0;
        int right = 0;
        // 记录某一个字符出现的最大频次
        int historyMaxCount = 0;
        // 定义最大的结果集
        int res = 0;
        // 右指针开始往右走
        while (right < n) {
            // 记录字符的频次
            num[s.charAt(right) - 'A']++;
            // 记录最大频次
            historyMaxCount = Math.max(historyMaxCount, num[s.charAt(right) - 'A']);
            // 右指针往右走一步
            right++;
            // 下面判断是否满足替换k个字符，通过下标计算字符串，在通过最大字符数和k，判定可以替换的字符数
            if (right - left > k + historyMaxCount) {
                // 如果left - right 之间的字符，替换k个已经不满足了，需要把right继续向右移动
                // 关键点，k不够替换，left 和right 需要一起移动保证窗口的最大值，间接的也就忽略了最小值
                // 相应的left移动了，left对应字符的频次也是少了一个，需要减去
                num[s.charAt(left)-'A']--;
                left++;
            }
            // 如果上述条件不满足,则说明达到最长子串了，记录长度
            res = Math.max(res, right - left);


        }
        return res;

    }
}
