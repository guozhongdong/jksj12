package com.gzd.leetcode.array;

/**
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。
 * 返回让数组所有元素相等的最小操作次数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：0
 *  
 * 答案保证符合 32-bit 整数
 * <p>
 * 题解思路：
 * 数学思想解题
 * <p>
 * n-1 加1，保证所有元素都相等， 反证思想就是 让一个元素减1，最终与最小值相等即可
 * 先遍历一遍找到最小值
 * 在遍历一遍，计算每个元素与最小值的差值，即为需要操作的次数
 *
 * 这个思路真的奇妙！！！
 *
 * @author guozhongdong
 */
public class MinMoves_453 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        MinMoves_453 min = new MinMoves_453();
        System.out.println(min.minMoves(nums));
    }


    public int minMoves(int[] nums) {

        if (nums == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            }
        }

        // 计算次数
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] - min;
        }
        return sum;
    }
}
