package com.gzd.leetcode.doubletail;

import java.util.Arrays;

/**
 *
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 *
 * 参考三数之和的解法
 * 排序+双指针
 *
 * 返回的是最接近的时候，不是三元组，
 * 思考的时候，陷入了这么一个误区
 *
 *
 *
 */
public class ThreeSumClosest_16 {

    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {


        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-1 ; i++) {

            //减少一些无效判断
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int sum = nums[i] + nums[left]+nums[right];
                //算得一个最接近的值，更新ans
                if (Math.abs(target - sum) < Math.abs(target- ans)){
                    ans = sum;
                }
                if (sum > target){
                    right--;

                }else if (sum < target){
                    left++;
                }else {
                    return ans;
                }
            }
        }
        
        return ans;
    }
}
