package com.gzd.leetcode.greed.subarray;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，
 * 那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,1,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * 连续子数组，找无序对，取一个最大值和一个最小值
 * 1、排序，比较第一个数字变化的下标和最后一个数字变化的下标
 */
public class FindUnsortedSubarray_581 {

    public static void main(String[] args) {
        FindUnsortedSubarray_581 subarray = new FindUnsortedSubarray_581();
        int[] nums = {1, 2, 3, 4};
        System.out.println(subarray.findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        Arrays.sort(nums);
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != res[i]) {
                minIndex = i;
                break;
            }
        }
        int maxIndex = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != res[i]) {
                maxIndex = i;
                break;
            }
        }
        if (maxIndex == minIndex) {
            return 0;
        }

        return maxIndex - minIndex + 1;
    }


    /**
     * O(n)的时间复杂度
     * <p>
     * 一次遍历确定左右边界
     */
    public int findUnsortedSubarray1(int[] nums) {

        int n = nums.length;
        int maxR = Integer.MIN_VALUE;
        int minL = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
        for (int i = 0; i < n; i++) {
            if (maxR > nums[i]) {
                right = i;
            } else {
                maxR = nums[i];
            }

            if (minL < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minL = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

}
