package com.gzd.leetcode.hash;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案s
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 非递减顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 * <p>
 * <p>
 * 暴力解法
 * <p>
 * 思路：
 * 1、非递减数组
 * 2、一定存在的唯一的答案
 * 3、不使用额外空间
 * 4、不重复使用元素
 * 使用两个指针a, b ,如果a+b < target,则b++;,如果a+b > target,</>
 */
public class TwoSumII_167 {

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        TwoSumII_167 twoSum = new TwoSumII_167();
        twoSum.twoSum1(nums, -2);
    }

    /**
     * 暴力解法
     * <p>
     * 执行用时：1053 ms在所有 Java 提交中击败了5.01%的用户
     * 内存消耗：44.3 MB, 在所有 Java 提交中击败了38.24%的用户
     * 通过测试用例：21 / 21
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    break;
                }
            }
        }
        return res;
    }


    /**
     * 2 3 6 8 9 11  t = 9
     * <p>
     * -4 -2 -1 -1 0    t = -5
     * 尝试双指针
     * <p>
     * 递增特性，且存在唯一解
     * <p>
     * O(n)
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length - 1;
        int b = 0;
        while (b < n) {
            if (numbers[b] + numbers[n] > target) {
                n--;
            } else if (numbers[b] + numbers[n] < target) {
                b++;
            } else {
                res[0] = b + 1;
                res[1] = n + 1;
                break;
            }

        }
        return res;
    }


    /**
     * 利用非递减的性质
     * 使用二分法，固定一个数，找另一个数
     * target知道
     * 2 3 7 9 11    t = 9;
     * <p>
     * 2 3 5 7 11   （ 9 11） 不要了
     * <p>
     * i对应的数是基准数
     * O(Nlog(n))
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int high = numbers.length - 1;
            int left = i + 1;
            while (left <= high) {
                int mid = left + (high - left) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                } else if (numbers[mid] < target - numbers[i]) {
                    left = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return res;
    }

}
