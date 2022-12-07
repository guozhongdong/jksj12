package com.gzd.leetcode.doubletail;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * <p>
 * 理解题意
 * 这个4个数，可以组成三角形的任意一个边
 * a b c
 * 当a=4 时  4 2 3， 4 2 4， 4 3 4
 * 当a=2 时  2 3 4
 * <p>
 * a+b > c
 * <p>
 * 枚举过的数，不要再用了，
 * <p>
 * 排序+ 双指针
 */
public class TriangleNumber_611 {

    public static void main(String[] args) {

        TriangleNumber_611 number = new TriangleNumber_611();
        int[] nums = {3, 4, 4, 2};
        System.out.println(number.triangleNumber(nums));

    }

    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        // 2 3 4 4,找到i，在0-i之间找到 k和j
        for (int i = nums.length - 1; i >= 2; i--) {
            // 定义两个指针，从0-i之间开始查找
            int left = 0;
            int right = i - 1;
            // 最少保证i往前还剩两个数
            while (left < right) {
                // 两条短边之和大于第三边
                if (nums[left] + nums[right] > nums[i]) {
                    // 如果left+right的指大于i，则i到到之间的数，
                    // 都是满足的，所以ans 需要加上区间里的数并且 right往下减,继续查找
                    ans += right - left;
                    --right;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
