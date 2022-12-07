package com.gzd.leetcode.doubletail;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 不需要考虑数组中超出新长度后面的元素。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 */
public class RemoveDuplicates_80 {

    public static void main(String[] args) {
        RemoveDuplicates_80 d = new RemoveDuplicates_80();
        int[] nums = {1, 1, 1,1,1, 2, 2,2, 3};
        System.out.println(d.removeDuplicates(nums));
    }


    /**
     * 参考27题，
     * 关键因素 ：连续 ，有序，
     * 大于2次以上的删除，
     * 思路：将遍历的区间加2
     *
     *
     */
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n <= 2){
            return n;
        }
        int left = 2;
        int right = 2;
        while (right < n) {
             //  1, 1, 1,1,1, 2, 2,2, 3
             //  1 1 2 2 2 2
            if (nums[left-2] != nums[right]) {
                // 说明重复的数据大于2
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        return left;
    }

    public int process(int[] nums, int k) {

        int n = 0;
        for (int num : nums) {
            if (n < k || nums[n-k] != num){
                nums[n++] = num;
            }
        }
        return n;
    }
}
