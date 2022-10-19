package com.gzd.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *  
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 * hash表就简单了，直接遍历一遍，把nums[i] 都放到hash表，遇到值相等，就判断下标差值，
 */
public class ContainsNearbyDuplicate_219 {

    public static void main(String[] args) {
        ContainsNearbyDuplicate_219 duplicate = new ContainsNearbyDuplicate_219();
        int[] nums = {1, 2, 3, 1, 2, 3};
        System.out.println(duplicate.containsNearbyDuplicate(nums, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 1 0 1 1 1 1 1
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                int n = map.get(nums[i]);
                if (Math.abs(i - n) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;

    }

    /**
     * 滑动窗口
     * 通过i j  k ,反推重复元素，
     * 如果在窗口内存在重复元素，那肯定就符合
     * 窗口初始大小是 k
     * 遍历数组，当i>k ,还没有重复元素，则提出 i-k-1的元素
     * <p>
     * 1,2,3,1,2,3
     * k = 2;
     * <p>
     * 用hash表保存窗口内的元素
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 如 k = 2 ,i = 3, 则需要把i-k-1位置的元素删除，如果i位置的元素在窗口内有，
            // 则直接返回true
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;

    }
}
