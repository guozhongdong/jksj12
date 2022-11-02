package com.gzd.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * <p>
 * 思路：
 * 和为k的连续子数组的个数
 * <p>
 * 一开始看了前缀和的例子，把自己绕进去了，最简单的枚举也忘了，
 * <p>
 * ----------------
 * 枚举解法：
 * 遍历数组，每一个数组，寻找 j-i 之间的和是k
 */
public class SubarraySum_560 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -3};
        SubarraySum_560 sum = new SubarraySum_560();
        sum.subarraySum(nums, 3);
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // 1 1 1 1 1   k = 2
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;

    }

    /**
     * hash表+前缀和优化
     * <p>
     * 看题解，看半天也是没看懂啥意思
     * pre[i] - pre[i-1] == k 的满足
     * j到i的子数组的和为k，如何推导出工时 pre[i]-pre[i-1] = k的呢
     * <p>
     * 3 4 7 2 -3
     * 0---1 的和为7，i = 1 ,j= 0，
     * 默认和为0的前缀和为1
     */
    public int subarraySum1(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 公式的 pre[i],如果map中存在 pre[i]-k 的值，就说明0到i位置连续的子数组内，是存在
            // 和为k的子数组
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;

    }
}
