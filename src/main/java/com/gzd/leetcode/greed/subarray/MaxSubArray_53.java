package com.gzd.leetcode.greed.subarray;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *  
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * 1、暴力解法。直接遍历求和每个数字开始的和
 */
public class MaxSubArray_53 {

    public static void main(String[] args) {
        MaxSubArray_53 sub = new MaxSubArray_53();
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(sub.maxSubArray(nums));
    }

    /**
     * 暴力解法超出时间限制
     */
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int subSum = nums[i];
            int count = nums[i];
            // 这一趟下来，找到以i开头元素的最大和
            for (int j = i + 1; j < nums.length; j++) {
                subSum = subSum + nums[j];
                count = Math.max(count, subSum);
            }
            sum = Math.max(sum, count);

        }
        return sum;
    }

    /**
     * 贪心
     * 记录当前和 和 最大和
     * 直接遍历计算当前和，然后和最大和比较，取最大值
     *
     * 动态转移方程：
     * f(i)=max{f(i−1)+nums[i],nums[i]}
     *
     * 参考题解：
     * https://leetcode.cn/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
     *
     * 讲的清晰
     *
     */
    public int maxSubArray1(int[] nums) {
        int pre = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxSum = Math.max(maxSum, pre);
        }

        return maxSum;
    }
}
