package com.gzd.leetcode.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * 思路：
 * 两次遍历，第一次遍历，如果i位置是0，
 * 0 1 0 3 12
 * 看完题解思路有三种：
 * 1、暴力解法
 * 2、双指针
 * 3、改变数组索引，两次遍历，一次遍历遇到0,count++,非0的数，放到当前i-count处，意思是前面有count个位置出现0了，我直接往前放，
 * 覆盖掉0所在的位置，
 * 0 1 0 3 12
 * 结果：1 3 12 3 12
 * 然后将count里计算0的个数从后往前补0
 *
 *
 *
 * @author guozhongdong
 */
public class MoveZeroes_283 {

    public static void main(String[] args) {
        int[] nums = {1, 0};
        MoveZeroes_283 move = new MoveZeroes_283();
        //move.moveZeroes(nums);
        //move.moveZeroes1(nums);
        move.moveZeroes2(nums);
    }

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        /**
         * 0 1 0 3 12
         * 1 0 0 3 12
         * 1 3 0 0 12
         *
         * 1 3 12 0 0
         *
         */
        for (int i = 0; i < nums.length; i++) {
            // 将与下一个非0 的数进行交换
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 双指针
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null) {
            return;
        }
        int n = nums.length - 1;
        // 指向非0的集合
        int left = 0;
        // 指向0的集合
        int right = 0;
        // 如果两个指针相交，则左边全部是非0,右指针全部是0
        while (right <= n && left <= n) {
            /**
             * 两个指针开始都是指向0处，左指针的左边是非0的末尾，如果遇到数了，继续往末尾加
             * 右指针往右找非0的数，指向非0数的开头
             * 0 1 0 3 12
             */
            // 右指针开始了遇到了第一个不是0的数，开始交换位置了，
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;


        }
    }

    /**
     * 索引法
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        int n = nums.length - 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                count++;
                continue;
            }
            // 交换位置,将i位置的树，当道i-count处
            nums[i-count] = nums[i];
        }
        // 再次遍历，补0
        while (count > 0){
            nums[n - count] = 0;
            count--;
        }
    }
}
