package com.gzd.leetcode.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * <p>
 * 思路：定义一个最大值空间的数组
 */
public class LongestConsecutive_128 {

    public static void main(String[] args) {
        LongestConsecutive_128 consecutive = new LongestConsecutive_128();
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        //System.out.println(consecutive.longestConsecutive(nums));
        System.out.println(consecutive.longestConsecutive1(nums));
    }

    /**
     * hash表+排序
     *
     * 时间复杂度最坏情况下达到了O(n^2)
     *
     * 执行用时: 26 ms
     * 内存消耗: 57.3 MB
     */
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int pre = list.get(0);
        int temp = 1;
        int result = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == pre + 1) {
                temp++;
                pre = list.get(i);
            } else {

                result = Math.max(result, temp);
                pre = list.get(i);
                temp = 1;
            }
        }
        result = Math.max(result, temp);
        return result;
    }


    /**
     * hash表解决O(n) 时间复杂度
     * <p>
     * 核心思路:用hash表保存了元素后，为了避免重复，需要当前元素的前一个元素是否存在，如果存在就不做处理，如果不存在
     * 则当前元素就是遍历的开端
     *
     * 执行用时: 258 ms
     * 内存消耗: 57.5 MB
     *
     * 并没有比暴力优化提升多少？？？
     */
    public int longestConsecutive1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int result = 0;
        // 在遍历一次，寻找连续的子序列
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }

            int a = nums[i];
            while (set.contains(a)) {
                a = a + 1;
            }
            result = Math.max(result, a - nums[i]);

        }
        return result;
    }

}
