package com.gzd.leetcode.array;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 * @author guozhongdong
 */
public class FirstMissingPositive_41 {

    public static void main(String[] args) {

        FirstMissingPositive_41 f = new FirstMissingPositive_41();
        int[] nums = {3,4,-1,1};
        //System.out.println(f.firstMissingPositive(nums));
        System.out.println(f.firstMissingPositive2(nums));

    }

    /**
     * 题解经典思路：
     * 对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1, N+1] 中。
     * 这是因为如果 [1, N] 都出现了，那么答案是 N+1，否则答案是 [1, N]中没有出现的最小正整数
     *
     * 关键点2，利用hash表存储的原理，将1-N的数存到数组里
     *
     * 1-n 对应数组下标
     */
    public int firstMissingPositive(int[] nums) {

        if (nums == null) {
            return -1;
        }
        int n = nums.length;
        // 打标
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0){
                nums[i] = n+1;
            }
        }
        // 核心步骤，不好理解
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }


    /**
     * 将数组内属于1-N的数，放到对应的下标数
     * 如
     * 3 4 -1 1
     * 放完如下：
     * 1 -1 3 4 ，遍历数组，发现那个数跟下标对不上，就是缺失的，如果都不缺就是n+1
     *
     * 跳出循环是关键点
     * 置换元素，将属于1-n的数，放到正确的下标下面，同找重复数类似
     * 边界条件
     * x 属于1-n 闭区间
     * 当前下标i上的元素 x 与 nums[x-1] 下标处的值不相等，相等话如果满足了，
     * 比如i=1,nums[i] = 2,num[2-1] == nums[1] = 2,
     * 比如i=1 ,nums[i] = 5 ,nums[5-1] = nums[4] == 5,
     *
     *
     *
     *
     */
    public int firstMissingPositive2(int[] nums) {

        if (nums == null) {
            return -1;
        }
        int n = nums.length;
        // 打标
        for (int i = 0; i < n; i++) {
            // 特别注意边界条件
            while (nums[i]>=1 && nums[i] <= n && nums[i] != nums[nums[i]-1]){
                // 交换
                swap(nums,i,nums[i]-1);
            }
        }

        // 返回第一个错误位置对应的下标
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1){
                return i+1;
            }

        }
        return n+1;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
