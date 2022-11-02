package com.gzd.leetcode.greed;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
 * 如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 *
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 *
 *
 * 使用hash表保存nums2的元素与下标的关系
 * [1,3,5,2,4]
 * [6,5,4,3,2,1,7]
 *
 */
public class NextGreaterElement_496 {

    public static void main(String[] args) {
        NextGreaterElement_496 element_496 = new NextGreaterElement_496();
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        element_496.nextGreaterElement(nums1,nums2);
    }


    /**
     * 可以不用map，直接暴力查找
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i],i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            if (map.get(n)+1 < nums2.length ){
                int in = map.get(n)+1;
                while (in < nums2.length && nums2[in] < n){
                    in++;
                }
                if (in < nums2.length){
                    res[i] = nums2[in];
                }else {
                    res[i] = -1;
                }

            }else {
                res[i] = -1;
            }
        }
        return res;
    }


    /**
     * 进阶做法
     * 单调栈，保证栈内元素，从栈底到栈顶是单调递减的
     *
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        // 保留第二个数组的元素，
        Stack<Integer> stack = new Stack<>();
        // 往后往前遍历nums2,从到靠右的最大值
        for (int i = nums2.length-1; i >= 0; i--) {

            int num = nums2[i];
            // 判断当前元素与栈顶元素的大小，如果大于，则把栈顶元素出栈，
            while (!stack.isEmpty() && num > stack.peek()){
                stack.pop();
            }
            // 如果当前元素不大于栈顶元素， 说明栈顶元素就是比当前元素的大的，靠右的
            // 保存hash表
            map.put(num,stack.isEmpty() ? -1 : stack.peek());
            // 将当前元素入栈
            stack.push(num);
        }
        // 遍历数组1，组装结果
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);

        }
        return res;

    }
}
