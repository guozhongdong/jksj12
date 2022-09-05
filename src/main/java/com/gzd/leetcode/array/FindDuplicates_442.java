package com.gzd.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhongdong
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，
 * 且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * <p>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现 一次 或 两次
 */
public class FindDuplicates_442 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        //System.out.println(findDuplicates(nums));
        System.out.println(findDuplicates1(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            return list;
        }
        /**
         * 假使nums[i]位置的数是x，则设置nums[x-1]位置的数+n,
         * 如果有重复，肯定两个位置的数加的是同一个地方，导致有一个位置肯定没动
         * 4,3,2,7,8,2,3,1
         *
         *
         */
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            if (temp > n) {
                if (temp % n == 0) {
                    temp = temp % n + n;
                } else {
                    temp = temp % n;
                }
                if (nums[temp - 1] > n) {
                    list.add(temp);
                }
            } else {
                if (nums[temp - 1] > n) {
                    list.add(temp);
                }
            }


            nums[temp - 1] = nums[temp - 1] + n;
        }
        return list;

    }


    public static List<Integer> findDuplicates1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            return list;
        }
        /**
         * 数字范围1-n
         * 将nums[i]里的数字x，都放到对应的额x-1下标处，
         * 如果x-1 坐标处的数字跟x相等了，则认为是重复的，记录下来
         *  4,3,2,7,8,2,3,1
         *  3 2 3 4 8 2 7 1
         */
        for (int i = 0; i < n; i++) {
            // 这个思路很秒，如果有两个相等数，为啥相等就退出循环了
            // 相等就代表nums[i] 放到它对应数的下标里了，
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1){
                list.add(nums[i]);
            }
        }
        System.out.println("");
        return list;

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
