package com.gzd.leetcode.greed.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），
 * 返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * 创建一个单调递增的栈
 */
public class NextGreaterElements_503 {

    public static void main(String[] args) {
        NextGreaterElements_503 elements = new NextGreaterElements_503();
        int[] nums = {1, 2, 1};
        int[] res = elements.nextGreaterElements(nums);
        int[] res1 = elements.nextGreaterElements(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i] + " ");
        }

    }

    /**
     * 暴力解法
     */
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            j = j % n;
            // 当前元素，找到一个比它大的，可循环
            int num = nums[i];
            int maxNum = -1;
            while (j != i) {
                if (nums[j] > num) {
                    maxNum = nums[j];
                    break;
                }
                j++;
                j = j % n;
            }
            res[i] = maxNum;
        }

        return res;
    }

    /**
     * 单调栈解法
     * 3,2,1,2,3
     * <p>
     * 从左到右遍历，栈内单调递减，知道遇到一个大的元素，栈顶元素比栈底的小，将栈顶元素弹出，保存
     * 再次比较，后续元素
     * 栈中存放的是nums[i]对应的下标，往后遍历如果遇到比i位置的数大的元素，直接把i，
     */
    public int[] nextGreaterElements1(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        // 初始化，找不到大的，就默认-1
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        // 开始遍历查找，拉平原数组
        for (int i = 0; i < 2 * n - 1; i++) {
            int j = i % n;
            // 栈不为空，并且栈顶元素对应的数和当前j位置的元素的比较，小，则说明
            // j位置大于i，将i从栈里弹出来，
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]){
                res[stack.pop()] = nums[j];
            }
            // 每次把当前下标添加进去，
            stack.push(j);
        }

        return res;
    }
}
