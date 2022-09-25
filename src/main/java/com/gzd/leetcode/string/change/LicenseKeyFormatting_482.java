package com.gzd.leetcode.string.change;

/**
 * 给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。
 * 字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
 * <p>
 * 我们想要重新格式化字符串 s，使每一组包含 k 个字符，除了第一组，
 * 它可以比 k 短，但仍然必须包含至少一个字符。此外，两组之间必须插入破折号，
 * 并且应该将所有小写字母转换为大写字母。
 * <p>
 * 返回 重新格式化的许可密钥 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "5F3Z-2e-9-w", k = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *      注意，两个额外的破折号需要删掉。
 * 示例 2：
 * <p>
 * 输入：S = "2-5g-3-J", k = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 只包含字母、数字和破折号 '-'.
 * 1 <= k <= 104
 * <p>
 * 思路：
 * 将原字符串按破折号分组，
 * 判断第一个分组的字符串是不是小于等于k，满足的直接算一个
 * 如果多了，将多个字符添加到后面的分组里去
 * <p>
 * 小写变大写，数字不动
 * <p>
 * 倒着遍历
 * 从前遍历，不好保证后面的每组都是k个字符
 *
 * @author guozhongdong
 */
public class LicenseKeyFormatting_482 {

    public static void main(String[] args) {
        LicenseKeyFormatting_482 formatting = new LicenseKeyFormatting_482();
        System.out.println(formatting.licenseKeyFormatting("---", 3));
        System.out.println(formatting.licenseKeyFormatting1("---", 3));
    }

    public String licenseKeyFormatting(String s, int k) {

        // 按破折号分组
        String[] str1 = s.split("-");
        // 记录新分组中要达到k个字符串
        StringBuilder sb = new StringBuilder();
        // 5F3Z1-2e-9-w
        int n = str1.length - 1;
        StringBuilder sb1 = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            String s1 = str1[i];
            // 按字符串倒叙走
            int n1 = s1.length() - 1;
            while (n1 >= 0) {
                if (sb1.length() == k) {
                    sb.append(sb1);
                    sb.append('-');
                    sb1 = new StringBuilder();
                }
                sb1.append(s1.charAt(n1));
                n1--;
            }

        }
        if (sb1.length() > 0) {
            sb.append(sb1);
        }
        //
        return sb.reverse().toString().toUpperCase();
    }


    /**
     * 优化：直接遍历字符串
     * 1、从后向前遍历
     * 2、不要破折号
     * 3、如果长度 % k == 0,则往后追加一个破折号，继续遍历，
     * 4、记住要去掉最后一个破折号
     */
    public String licenseKeyFormatting1(String s, int k) {

        StringBuilder sb = new StringBuilder();
        // 设置一个位置，追加破折号好的
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c1 = s.charAt(i);
            if (c1 != '-') {
                sb.append(Character.toUpperCase(c1));
                cnt++;
                if (cnt % k == 0) {
                    sb.append('-');
                    cnt = 0;
                }
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length()-1) == '-'){
            sb = sb.deleteCharAt(sb.length()-1);
        }

        //
        return sb.reverse().toString();
    }
}
