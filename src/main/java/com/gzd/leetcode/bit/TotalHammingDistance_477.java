package com.gzd.leetcode.bit;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <p>
 * 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间 汉明距离的总和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,14,2]
 * 输出：6
 * 解释：在二进制表示中，4 表示为 0100 ，14 表示为 1110 ，2表示为 0010 。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6
 * 示例 2：
 * <p>
 * 输入：nums = [4,14,4]
 * 输出：4
 *  
 * <p>
 * 数组中的每两个数，两两计算汉明距离，最后求总和
 */

public class TotalHammingDistance_477 {

    public static void main(String[] args) {
        TotalHammingDistance_477 distance = new TotalHammingDistance_477();
        int[] nums = {4, 14, 2};
        System.out.println(distance.totalHammingDistance(nums));
    }

    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum += caculate(nums[i], nums[j]);
            }
        }
        return sum;
    }


    private int caculate(int x, int y) {
        // 0100
        // 1110
        // 1010
        int res = x ^ y;
        int count = 0;
        while (res != 0) {
            res = res & (res - 1);
            count++;
        }
        return count;
    }
}
