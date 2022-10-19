package com.gzd.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 */
public class Intersection_349 {

    public static void main(String[] args) {
        Intersection_349 inter = new Intersection_349();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        inter.intersection(nums1,nums2);
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])){
                set1.add(nums2[i]);
            }
        }
        int[] ans = new int[set1.size()];
        int k = 0;
        for (Integer integer : set1) {
            ans[k++] = integer;
        }
        return ans;
    }
}
