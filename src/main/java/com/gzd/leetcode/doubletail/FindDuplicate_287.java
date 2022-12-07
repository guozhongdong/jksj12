package com.gzd.leetcode.doubletail;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），
 * 可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *  
 * <p>
 * 进阶：
 * <p>
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 * <p>
 * 将数组内的数放到对应的下标内
 */
public class FindDuplicate_287 {

    public static void main(String[] args) {
        FindDuplicate_287 findDuplicate = new FindDuplicate_287();
        int[] nums = {1, 3, 4, 2, 2};
        findDuplicate.findDuplicate(nums);
    }

    public int findDuplicate(int[] nums) {
        // n+1 个数
        int n = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (nums[num-1] == num){
                return num;
            }else{

            }
        }


        return 0;
    }
}
