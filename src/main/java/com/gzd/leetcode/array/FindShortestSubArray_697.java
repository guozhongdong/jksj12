package com.gzd.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找数组的度
 * 数组里某个数出现最多的频次
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,3,1]
 * 输出：2
 * 解释：
 * 输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
 * 连续子数组里面拥有相同度的有如下所示：
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,2,3,1,4,2]
 * 输出：6
 * 解释：
 * 数组的度是 3 ，因为元素 2 重复出现 3 次。
 * 所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
 * <p>
 * 看懂题，占这个题的50%，
 * 最短子数组可以理解为数的最大下标减去 最小下标的值
 *
 * 一次遍历找出频次最大的数
 * 二次遍历找出出现这个数的最大位置和最小位置，他的区间就是最短的
 * 如果出现的多个度是相等，就分别计算，找他们最小的路径
 *
 * @author guozhongdong
 */
public class FindShortestSubArray_697 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        // 遍历一次找出出现度最高的数
        findShortestSubArray(nums);
        System.out.println("");
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxDu = Integer.MIN_VALUE;
        // 遍历一次找出出现度最高的数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 遍历map找度最大的数
        for (Integer max : map.values()) {
            maxDu = Math.max(maxDu, max);
        }

        int minLen = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entrys : map.entrySet()) {

            if (entrys.getValue() == maxDu) {
                int min = 0;
                int max = 0;
                // 找最小坐标
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == entrys.getKey()){
                        min = i;
                        break;
                    }
                }
                // 找最大坐标
                for (int j = nums.length-1; j >=0; j--) {
                    if (nums[j] == entrys.getKey()){
                        max = j;
                        break;
                    }
                }
                int len = max - min + 1;
                minLen = Math.min(minLen,len);
            }

        }

        return minLen;
    }

}
