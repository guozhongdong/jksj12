package com.gzd.leetcode.greed;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *  
 * <p>
 * 提示：
 * <p>
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 * <p>
 * 1、暴力解法，两两比较 + Hash表统计糖果数
 * <p>
 * 2、排序行不通
 * 参考题解思路：
 * 拆成左右两个规则遍历，
 * 左规则：处理 ratings[i] > ratings[i-1]的场景
 * 右规则：处理 ratings[i] > ratings[i+1]的场景，将左规则的相加
 * 题解解法2，
 * 常数空间
 * 这个解法很秒
 * 判断递增序列还是递减序列
 * <p>
 * 递减序列长度，递增序列长度，就是相对来说要加的糖果数
 */
public class Candy_135 {

    public static void main(String[] args) {

        Candy_135 candy = new Candy_135();
        int[] nums = {1,3,2,2,1};
        System.out.println(candy.candy1(nums));

    }

    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int[] left = new int[n];
        // 按左规则进行遍历
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                // 处理边界条件，第一次保存的时候
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        // 计算右规则
        int right = 0;
        // 和
        int res = 0;
        // 从倒数第二个开始
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            res += Math.max(left[i], right);
        }
        return res;
    }


    public int candy1(int[] ratings) {

        int n = ratings.length;
        int res = 1;
        int inc = 1;
        int dec = 0;
        // 记录前一个的糖果数
        int pre = 1;
        for (int i = 1; i < n; i++) {
            // 递增序列
            if (ratings[i] > ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
                inc = pre;
            } else {
                dec++;
                if (inc == dec) {
                    dec++;
                }
                res += dec;
                pre = 1;
            }

        }
        return res;
    }
}
