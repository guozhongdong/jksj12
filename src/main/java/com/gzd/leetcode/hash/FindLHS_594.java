package com.gzd.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * 思路：遍历一次数组，
 * 用hash表保存符合条件的元素，记录一下最大值和最小值
 * 排序后直接遍历
 */
public class FindLHS_594 {

    public static void main(String[] args) {
        FindLHS_594 lhs = new FindLHS_594();
        int[] nums = {1, 2, 3, 4};
        System.out.println(lhs.findLHS(nums));
        System.out.println(lhs.findLHS1(nums));
    }

    /**
     * 排序加暴力判断
     */
    public int findLHS(int[] nums) {

        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            int j = i;
            int count = 0;
            boolean flag = false;
            while (j < len && (nums[j] - n) <= 1) {
                if ((nums[j] - n) == 1) {
                    flag = true;
                }
                count++;
                j++;
            }
            if (flag) {
                max = Math.max(max, count);
            }
        }

        return max;
    }

    /**
     * hash表解法
     * <p>
     * 统计次数 当前数x 和 x+1的次数
     */
    public int findLHS1(int[] nums) {


        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i] + 1)) {
                res = Math.max(res, map.get(nums[i]) + map.get(nums[i] + 1));
            }
        }
        return res;
    }
}
