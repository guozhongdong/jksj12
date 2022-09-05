package com.gzd.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guozhongdong
 *
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗?
 * 你可以假定返回的数组不算在额外空间内。
 *
 *
 *
 */
public class FindDisappearedNumbers_448 {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,2,8,3,1};
        //System.out.println(findDisappearedNumbers(nums));
        //System.out.println(findDisappearedNumbers1(nums));
        System.out.println(findDisappearedNumbers2(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        // Hash表存数组内的数，key为nums[i],
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        // 遍历1到n
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)){
                list.add(i);
            }
        }
        return list;
    }
    /**
     * 使用原地数组
     *
     * nums[]里的数是1到n，遍历nums，找到nums里的数字x，让nums[x-1] 下标处的指加 n，
     * 一遍下来，说明缺少某个数，某个数下标对应的值肯定不会大于n
     * 思想很好
     *
     * 目标是1-n
     * 数组是nums
     * 4,3,2,7,2,8,3,1
     * 12,19,10,15,2,8,11,9
     *
     *
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {

        // Hash表存数组内的数，key为nums[i],
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // 关键地方， 当遍历到当前位置，当前位置的值已经被加过了，
            // 我们要取原始值就的取模
            int temp = nums[i];
            if (temp > n){
                if (temp % n == 0){
                    temp = temp % n + n;
                }else{
                    temp = temp % n;
                }

            }
            nums[temp-1] = nums[temp-1]+n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n){
                list.add(i+1);
            }
        }
        return list;
    }


    public static List<Integer> findDisappearedNumbers2(int[] nums) {

        // Hash表存数组内的数，key为nums[i],
        int n = nums.length;

        // 4,3,2,7,2,8,3,1
        // -4 -3 -2 -7 2 8 -3 -1
        for (int i = 0; i < n; i++) {
            // 遍历数组，将当前i位置对应数的x的下标变为负数
            // 1、如果i处的值为负数，则取绝对值，在算下标，
            // 2、如果x-1处的值为负数，说明重复了，不做操作
            // 我们要取原始值就的取模
            int temp = Math.abs(nums[i]);
            if (nums[temp -1] < 0){
                continue;
            }
            nums[temp-1] = -Math.abs(nums[temp-1]);

        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }

}
