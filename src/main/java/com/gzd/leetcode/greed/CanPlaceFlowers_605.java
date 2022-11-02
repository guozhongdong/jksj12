package com.gzd.leetcode.greed;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，
 * 它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，
 * 其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * <p>
 * 暴力解法，遍历数组，
 * 遇到1之后，判断下一个位置是不是0 ，是0 ，n--,不是0继续遍历
 * //
 * 0 0 0 0 0 1
 * <p>
 * 遍历数组，遇到0判断它的左右没有1，就可以种花
 *
 * 贪心算法，
 * 1、保持好边界问题点，就一个元素的时候，如何处理
 * 2、读懂题意，提炼题目中给定的关键信息
 */
public class CanPlaceFlowers_605 {

    public static void main(String[] args) {
        CanPlaceFlowers_605 flowers = new CanPlaceFlowers_605();
        int[] nums = {0, 1, 0};
        flowers.canPlaceFlowers(nums, 1);
    }


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        // 考虑边界值
        for (int i = 0; i < len; i++) {
            // 0,  00 ,
            // 0 1 0
            // 0 0 1 0 0
            if (flowerbed[i] == 0 && (i == len - 1 || flowerbed[i + 1] == 0)) {
                n--;
                i++;
            } else if (flowerbed[i] == 1){
                // 如果遇到i位置是1 的，则跳一格往下，题中明确不可能有相邻的话，
                // 所以跳过的这个格子肯定是0
                i++;
            }

        }

        return n ==  0;

    }
}
