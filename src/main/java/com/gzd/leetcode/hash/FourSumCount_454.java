package com.gzd.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 示例 2：
 * <p>
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 *  
 * <p>
 *   提示：
 * <p>
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 * <p>
 * 参考题解解法
 * A[i] + B[i] + C[i] + D[i]  = 0
 * A[i] + B[i] =  -(C[i] + D[i]);
 * <p>
 * 两两分组，计算和，保存和和次数的映射关系
 *
 * 类似累加和，都可以拆开成子项进行计算
 *
 */
public class FourSumCount_454 {

    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        // 保存结果对
        int res = 0;
        // 遍历 C D组
        for (int i : nums3) {
            for (int j : nums4) {
                // 如果map中存在这样的结果对，这说明符合，累加次数
                if (map.containsKey(-(i + j))) {
                    res += map.get(-(i + j));
                }
            }
        }
        return res;
    }

}
