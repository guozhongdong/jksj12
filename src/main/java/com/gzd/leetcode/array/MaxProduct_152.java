package com.gzd.leetcode.array;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,2,-2]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 * <p>
 * 思路1:
 * 求一个左缀和，在求一个右缀合，分别遍历取得最大值，
 * 子数组不包含原数组
 * 重点：考虑0的场景，就可完整的解题
 * <p>
 * <p>
 * 动态规划
 * <p>
 * 划出动态规划方程
 *
 * @author guozhongdong
 */
public class MaxProduct_152 {

    public static void main(String[] args) {
        int[] nums = {-2,0};
        MaxProduct_152 max = new MaxProduct_152();
        System.out.println(max.maxProduct(nums));
        System.out.println(max.maxProduct1(nums));
    }

    /**
     * 最原始的思路，忘记考虑里面含有0和含有负数的场景
     *
     */
    public int maxProduct1(int[] nums) {

        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int left = 1;
        // 需要考虑0的情况
        for (int i = 0; i < n; i++) {

            left = left * nums[i];
            max = Math.max(max, left);
            if (nums[i] == 0){
                left = 1;
            }
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            right = right * nums[i];
            max = Math.max(max, right);
            if (nums[i] == 0){
                right = 1;
            }
        }

        return max;

    }


    public int maxProduct(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 ){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(imax, max);
        }
        return max;

    }
}
