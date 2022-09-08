package com.gzd.leetcode.array;

/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *  
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 * @author guozhongdong
 */
public class Rotate_189 {

    public static void main(String[] args) {
        int[] nums = {3, 99, -1, -100};

        Rotate_189 rotate = new Rotate_189();
        //rotate.rotate(nums, 5);
        rotate.rotate2(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }

    /**
     * 暴力解法，用额外n-k容量的数组
     * 需要额外空间复杂度O(n)
     */
    public void rotate(int[] nums, int k) {

        if (k == nums.length) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }

        int n = nums.length;
        int[] tempA = new int[k];
        int[] tempB = new int[n - k];
        int p = 0;
        int q = 0;
        // 1,2
        for (int i = 0; i < n; i++) {
            if (i < n - k) {
                tempB[q++] = nums[i];
            } else {
                tempA[p++] = nums[i];
            }

        }
        for (int i = 0; i < k; i++) {
            nums[i] = tempA[i];

        }
        // 合并
        for (int i = 0; i < n - k; i++) {
            nums[i + k] = tempB[i];
        }
    }

    /**
     * 原地算法，不使用额外空间，看提示翻转k个元素，每一步操作一个
     */
    public void rotate1(int[] nums, int k) {

        if (k == nums.length) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }

        int n = nums.length;
        // 两个指针，一个指向最后一个元素，一个指向前面的元素，
        // 每次移动一个，将最后一个元素，移动到最前面
        // 总共移动k步
        // 1 2 3 4 5 6 7
        int p = n - 1;
        for (int i = 0; i < k; i++) {
            int temp = nums[p];
            for (int j = p; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }


    /**
     * 直接翻转数组
     * 然后按k位置继续翻转
     * 1 2 3 4 5 6 7
     * 7 6 5 4 3 2 1
     *
     * 5 6 7 1 2 3 4
     */
    public void rotate2(int[] nums, int k) {

        if (k == nums.length) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }

        int n = nums.length;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
