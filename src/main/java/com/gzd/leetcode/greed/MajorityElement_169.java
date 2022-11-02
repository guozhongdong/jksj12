package com.gzd.leetcode.greed;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *  
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 暴力解法，使用额外空间
 *
 *
 */
public class MajorityElement_169 {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int k = n/2;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() > k){
                return entry.getKey();
            }
        }
        return -1;

    }

    /**
     * 时间复杂度是O(n)
     * 空间复杂度是O(1)
     * 多的数出现的次数肯定是大于不多的
     */
    public int majorityElement1(int[] nums) {


        int n = nums.length;
        int m = nums[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == m){
                count++;
            }else {
                count--;
                if (count == 0){
                    m = nums[i+1];
                }
            }
        }

        return m;

    }
}
