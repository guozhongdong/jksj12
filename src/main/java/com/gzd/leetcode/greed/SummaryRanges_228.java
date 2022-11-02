package com.gzd.leetcode.greed;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
 * 并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 *
 * 思路：
 * 1、有序，无重复
 * 最小有序区间范围数据
 *
 * 直接遍历，定义一个start,定义一个end，start到end是连续的，则保存start->end
 * 如果某个数断开了，则重新计数
 * 需要考虑边界值
 *
 *
 */
public class SummaryRanges_228 {

    public static void main(String[] args) {
        SummaryRanges_228 ranges = new SummaryRanges_228();
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(ranges.summaryRanges(nums));
    }


    public List<String> summaryRanges(int[] nums) {

        if (nums.length == 0){
            return null;
        }
        // 0,2,3,4,6,8,9
        // 0,1,2,4,5,7
        List<String> list = new ArrayList<>();
        int i = 0;
        int n = nums.length-1;
        while (i <= n){
            int start = nums[i];
            int end = nums[i];
            while (i < n && nums[i]+1 == nums[i+1]){
                end = nums[i]+1;
                i++;
            }
            if (start == end){

                list.add(start+"");
            }else {
                list.add(start+"->"+end);
            }
            i++;
        }
        return list;
    }
}
