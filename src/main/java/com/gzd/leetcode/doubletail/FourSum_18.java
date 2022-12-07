package com.gzd.leetcode.doubletail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * [1000000000,1000000000,1000000000,1000000000]
 * -294967296
 *
 */
public class FourSum_18 {

    public static void main(String[] args) {

        FourSum_18 sum = new FourSum_18();

        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(sum.fourSum(nums, -294967296));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // 过滤重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long t2 = (long)target - (long)(nums[i] + nums[j]);
                int third = j + 1;
                int four = nums.length - 1;
                while (third < four) {
                    if (nums[third] + nums[four] == t2) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[i],
                                nums[j], nums[third], nums[four])));
                        third++;
                        four--;
                        while (third < four && nums[third] == nums[third - 1]) {
                            third++;
                        }
                        while (third < four && nums[four] == nums[four + 1]) {
                            four--;
                        }
                    } else if (nums[third] + nums[four] < t2) {
                        third++;
                    } else {
                        four--;
                    }
                }
            }
        }

        return ans;
    }
}
