package com.gzd.leetcode.doubletail;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，
 * 都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1],
 * nums[r]] 就是连续递增子序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * 根据题意标明了left 和 right
 * 如果left 到right 递增， 则下一次从right+1 开始
 * <p>
 * <p>
 * 。
 */
public class FindLengthOfLCIS_674 {

    public static void main(String[] args) {
        FindLengthOfLCIS_674 leng = new FindLengthOfLCIS_674();
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(leng.findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {

        int res = 0;
        int left = 0;
        int n = nums.length;
        while (left < n) {
            int k = left;
            int count = 1;
            while (k < n - 1 && nums[k] < nums[k + 1]) {
                count++;
                k++;
            }
            // 1,3,5,4,7
            left = k + 1;
            res = Math.max(res, count);
        }
        return res;
    }

    /**
     * 优化
     */
    public int findLengthOfLCIS1(int[] nums) {

        int res = 0;
        int left = 0;
        int n = nums.length;
        while (left < n) {
            int count = 1;
            while (left < n - 1 && nums[left] < nums[left + 1]) {
                count++;
                left++;
            }
            // 1,3,5,4,7
            left++;
            res = Math.max(res, count);
        }
        return res;
    }
}
