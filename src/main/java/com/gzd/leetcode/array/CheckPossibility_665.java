package com.gzd.leetcode.array;

/**
 *
 * 给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，
 * 该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，
 * 总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * 思路：遍历一遍数组，计算出相邻两个数是递减的个数，如果个数大于1，则改变
 * 一个元素，就达不到非递减(错误思路)
 * （单调递增）
 *
 * 题解思路：
 *
 * i等于1时，nums[i] 小于num[i-1],则调整i-1位置的数，为i位置的
 * 当i 位置的数，不满足单调 递增的时候，需要判断两次，
 *
 * 一次是nums[i] 与前一个位置的书进行比较，
 * 一次是nums[i]与前两个位置的数进行比较，如果两个都比nums[i]位置上的大，就将i位置的数变为i-1位置的数，
 * 如果nums[i-1] 大于nums[i],nums[i-2] 小于nums[i],将nums[i-1]位置的数，调整为nums[i],尽量不动i位置的数，
 * 整体这么处理后，
 * 在遍历一次
 *
 * @author guozhongdong
 * @date 2022/9/4 10:53
 *
 */
public class CheckPossibility_665 {

    public static void main(String[] args) {
        int[] nums = {3,4,2,5};
        CheckPossibility_665 check = new CheckPossibility_665();
        System.out.println(check.checkPossibility(nums));
    }


    /**
     * 3 4 2 5
     *
     */
    public boolean checkPossibility(int[] nums) {
        if (nums == null){
            return false;
        }
        if (nums.length == 1){
            return true;
        }
        /**
         * 4 2 5
         * 3 4 2 5
         * 1 4 2 5
         *
         * */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]){
                if (i == 1){
                    nums[i-1] = nums[i];
                    break;
                }else {
                    if (nums[i] < nums[i-2]){
                        nums[i] = nums[i-1];
                    }else {
                        nums[i-1] = nums[i];
                    }
                    break;
                }

            }
        }
        // 判断是否单调递增
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]){
                count++;
            }
        }
        return count < 1 ;
    }
}
