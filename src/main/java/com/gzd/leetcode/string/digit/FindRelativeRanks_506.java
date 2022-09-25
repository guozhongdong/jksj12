package com.gzd.leetcode.string.digit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。
 * 所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第2高，
 * 依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号
 * （即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * 示例 2：
 *
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 *
 * 排序
 * hash表
 *
 * @author guozhongdong
 */
public class FindRelativeRanks_506 {

    public static void main(String[] args) {
        FindRelativeRanks_506 ranks = new FindRelativeRanks_506();
        int[] nums = {10,3,8,9,4};
        String[] strs = ranks.findRelativeRanks(nums);
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i]+" ");
        }
    }

    public String[] findRelativeRanks(int[] score) {

        Map<Integer,Integer> map = new HashMap<>();
        int n = score.length-1;
        for (int i = 0; i < score.length; i++) {
            map.put(score[i],i);
        }
        Arrays.sort(score);
        String[] result = new String[score.length];
        // 遍历原数组
        int ming = 4;
        for (int j = n; j >= 0 ; j--) {
            if (j == n){
                result[map.get(score[j])] = "Gold Medal";
            }else if (j == n-1){
                result[map.get(score[j])] = "Silver Medal";
            }else if (j == n-2){
                result[map.get(score[j])] = "Bronze Medal";
            }else {
                result[map.get(score[j])]  = ming+"";
                ming++;
            }

        }
        return result;
    }

}
