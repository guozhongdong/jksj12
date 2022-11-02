package com.gzd.leetcode.greed;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * nums[i] 可能是三位数，三位数是一个整体，不可拆分，我们只参考最高位
 * 10-99
 * 100 -109
 * 遍历数组，每次取高位最大的数，即每次取一个最大值
 *
 * 参考题解，自定义排序
 * A+bc 和 bcA 比较大小
 *
 *
 */
public class LargestNumber_179 {

    public static void main(String[] args) {

    }

    public String largestNumber(int[] nums) {

        // 自定义排序 a+B < B+A
        // 4 45 和 45 4 ，454 > 445
        Integer[] ns = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ns[i] = nums[i];
        }
        // 开始自定义排序
        Arrays.sort(ns,(a,b) -> {
            String sa = String.valueOf(a);
            String s1b = String.valueOf(b);
            return (sa+s1b).compareTo(s1b+sa);
        });
        // 特殊值判断，如果最大值是0，则直接返回0，
        if (ns[0] == 0) {
            return "0";
        }
        // 遍历取值
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ns.length; i++) {
            sb.append(ns[i]);
        }

        return sb.toString();

    }
}
