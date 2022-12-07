package com.gzd.leetcode.doubletail;

/**
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 咋一看，直接弄个k区间，计算平均数
 */
public class FindMaxAverage_643 {

    public static void main(String[] args) {
        FindMaxAverage_643 age = new FindMaxAverage_643();
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(Double.MIN_VALUE);
        System.out.println(age.findMaxAverage(nums, 4));
        System.out.println(age.findMaxAverage1(nums, 4));


    }

    /**
     * 暴力解法超时
     */
    public double findMaxAverage(int[] nums, int k) {

        double res = Integer.MIN_VALUE;
        // 直接遍历
        for (int i = 0; i <= nums.length - k; i++) {
            int j = i + k;
            int nk = i;
            // 计算k个数的和
            int sum = 0;
            while (nk < j) {
                sum += nums[nk];
                nk++;
            }
            res = Math.max(res, Double.valueOf(sum) / Double.valueOf(k));
        }
        return res;
    }

    /**
     * 滑动窗口
     */
    public double findMaxAverage1(int[] nums, int k) {

        // 先求前k个的和，然后往后滑动一个数
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        //从k开始向后滑动
        int resSum = maxSum;
        for (int i = k; i < nums.length; i++) {
            maxSum = maxSum - nums[i - k] + nums[i];
            resSum = Math.max(maxSum, resSum);
        }
        return 1.0 * maxSum / k;
    }
}
