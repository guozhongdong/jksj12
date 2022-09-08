package com.gzd.leetcode.array;

/**
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 
 * 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？
 * （ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * 思路1： 暴力解法，o(N^2)
 * 空间复杂度：
 *
 * 思路2：前缀和，可左，可右，使用额外的数组空间存储前缀和，
 * 如果到 i处，则左前缀和 * 右前缀和，就是最终的结果
 * 时间复杂度O(n),空间复杂度O(n) n为数组长度
 *
 *
 * @author guozhongdong
 */
public class ProductExceptSelf_304 {

    public static void main(String[] args) {

        ProductExceptSelf_304 self = new ProductExceptSelf_304();
        int[] nums = {1,2,3,4};
        //self.productExceptSelf(nums);
        self.productExceptSelf1(nums);

    }

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length-1;
        int[] leftSum = new int[nums.length];

        int[] rightSum = new int[nums.length];

        int[] result = new int[nums.length];

        /**
         * 1 2 3 4
         * 求左前缀和
         * 1 2 6 24
         * 右前缀和
         * 24 24 12 4
         */
        leftSum[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = nums[i-1]*leftSum[i-1];
        }
        // 1 2 3 4
        rightSum[n] = 1;
        for (int i = n-1; i >= 0; i--) {
            rightSum[i] = nums[i+1]*rightSum[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] =  leftSum[i] * rightSum[i];
        }

        return result;
    }

    /**
     * 去掉左缀和 和 右缀和的数组
     * 用结果数组标注左缀和，然后动态实时的计算右缀和
     * 更新结果数组
    *
     */
    public int[] productExceptSelf1(int[] nums) {

        int n = nums.length-1;


        int[] result = new int[nums.length];

        /**
         * 1 2 3 4
         * 求左前缀和
         * 1 2 6 24
         * 右前缀和
         * 24 24 12 4
         */
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i-1]*result[i-1];
        }
        /**
         *  1 2 3 4
         *  result = {1,1,2,6};
         *
         */
        // R代表右侧的前缀和，由于最右边的一个元素右边没有数字，所以前者和为1
        // 所有当前i位置的和为；leftNum[i] * R
        int R = 1;
        for (int i = n; i >= 0; i--) {
            result[i] = result[i]*R;
            // 当前i位置的和计算完后，需要保留当前i位置右侧的和，给i左边的元素用，即i-1的有缀合就是R
            R *= nums[i];
        }

        return result;
    }
}
