package com.gzd.leetcode.doubletail;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1,
 * numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * <p>
 * 12,28,83,  4,  25,  26,  25,  2,  25,   25,   25,  12
 *
 * 未完待续
 */
public class MinSubArrayLen_209 {


    public static void main(String[] args) {
        MinSubArrayLen_209 arrayLen_209 = new MinSubArrayLen_209();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(arrayLen_209.minSubArrayLen(7, nums));
        System.out.println(arrayLen_209.minSubArrayLen1(7, nums));
    }

    /**
     * 暴力解法,超出时间限制
     */
    public int minSubArrayLen(int target, int[] nums) {

        int res = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target) {
                return 1;
            }
            // 1+4 6 7
            // 0 1 2 3
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    res = Math.min(j - i + 1, res);
                    break;
                }
            }


        }

        return res > nums.length ? 0 : res;
    }

    /**
     * 优化
     * O(n) 的时间复杂度
     * 2,3,1,2,1,3  4
     * 12,28,83,  4,  25,  26,  25,  2,  25,   25,   25,  12
     *
     * 参考题解，滑动窗口，
     *
     * 从第一个元素开始，找到目标和等于target的值，并记录窗口大小，向右滑动一个元素，并把第一个元素去掉
     * 如果此时和还大于target，则继续取前面的元素，记录窗口大小，直到不大于
     * 如果小于target 则此时i位置的元素，可以忽略了， 就算最后满足，窗口的长度肯定也是大于target 了
     *
     *
     *
     *
     *
     *
     */
    public int minSubArrayLen1(int target, int[] nums) {

        int res = 0;
        int sum = 0;
        // 记录窗口的坐下标
        int len = 0;
        // 2,3,1,2,1,3,4
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 此时形成了一个窗口
            while (sum >= target){
                // 开始记录窗口大小，并向右滑动,需要考虑第一次的情况
                res = res > 0 ? Math.min(i-len+1, res): i-len+1;
                // 开始向右继续滑动
                sum -= nums[len];
                len++;
            }
        }

        return res;
    }
}
