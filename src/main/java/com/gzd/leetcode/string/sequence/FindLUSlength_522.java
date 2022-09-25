package com.gzd.leetcode.string.sequence;

/**
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
 * <p>
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * <p>
 *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * <p>
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。
 * "aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 *  
 * <p>
 * 提示:
 * <p>
 * 2 <= strs.length <= 50
 * 1 <= strs[i].length <= 10
 * strs[i] 只包含小写英文字母
 * <p>
 * <p>
 * 这个得判断了
 * 判断短得字符串是不是长得 字符串得子序列
 *
 * @author guozhongdong
 * @date 2022/9/21 23:21
 */
public class FindLUSlength_522 {

    public static void main(String[] args) {
        FindLUSlength_522 findLUSlength = new FindLUSlength_522();
        String[] strs = {"aabbcc","aabbcc","cd"};
        System.out.println(findLUSlength.findLUSlength(strs));
    }

    public int findLUSlength(String[] strs) {

        // 记录最长特殊序列的长度
        String str = strs[0];
        int max = str.length();
        for (int i = 1; i < strs.length; i++) {
            if (str.equals(strs[i])) {
                str = strs[i];
                max = -1;
                continue;
            }
            if (str.length() < strs[i].length()) {

                if (!isSequence(str, strs[i])) {
                    max = strs[i].length();
                }else {
                    max = -1;
                }
                str = strs[i];
            } else {
                if (!isSequence(strs[i], str)) {
                    max = str.length();
                }else {
                    max = -1;
                }
            }
        }
        return max;
    }


    public int findLUSlength1(String[] strs) {

        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSequence(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSequence(String s, String t) {
        int s1 = 0;
        int t1 = 0;
        while (s1 < s.length() && t1 < t.length()) {
            if (s.charAt(s1) == t.charAt(t1)) {
                s1++;

            }
            t1++;
        }
        return s1 >= s.length();
    }
}
