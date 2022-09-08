package com.gzd.leetcode.array;

/**
 * 给定一个长度为 n 的整数数组 nums 。
 * <p>
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
 * <p>
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
 * <p>
 * 生成的测试用例让答案符合 32 位 整数。
 *
 * @author guozhongdong
 */
public class MaxRotateFunction_396 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        MaxRotateFunction_396 max = new MaxRotateFunction_396();
        System.out.println(max.maxRotateFunction(nums));
    }


    /**
     * 4 3 2 6
     * n = 4
     * 公式
     * F(0) = 0*A1 +1*A2 + 2*a3 + 3*a4
     * f(1) = 0*a4 + 1*a1 + 2*a2 + 3 * a3
     * f(2) = 0*a3 + 1*a4 + 2*a1 + 3*a2
     * f(3) = 0*a2 + 1*a3 + 2*a4 + 3*a1
     * <p>
     * f(1) - f(0) = 1*a1 + 1*a2 + 1*a3 - 3*a4;
     * <p>
     * f(1) = f(0) + sum - 4*a4
     *
     * f(2) = f(1) + sum -4*a3
     * f(3) = f(2) + sum -4*a2
     */
    public int maxRotateFunction(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // 代表所有数组额元素的和
        int sumRes = 0;
        for (int i = 0; i < nums.length; i++) {
            sumRes += nums[i];
        }

        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            f += i * nums[i];
        }
        int res = f;

        for (int i = nums.length-1; i > 0; i--) {
            f += sumRes - nums.length * nums[i];
            res = Math.max(res, f );
        }
        return res;
    }


}
