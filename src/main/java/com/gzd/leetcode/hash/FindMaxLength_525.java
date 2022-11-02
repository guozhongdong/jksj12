package com.gzd.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * <p>
 * 思路：
 * hash表+前缀和
 * 对前n个数求和，得到的值/n 等到0.5 就是满足的
 * <p>
 * 1 1 0 1 0
 * <p>
 * 子数组的和 * 2 = 长度
 * 每次跳两格遍历
 */
public class FindMaxLength_525 {

    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {

        //  1 1 1 0 1 0
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum * 2 == j - i + 1) {
                    count = Math.max(count, j - i + 1);
                }
            }
        }
        return count;
    }


}
