package com.gzd.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，
 * 并返回不同的 k-diff 数对 的数目。
 * <p>
 * k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 * <p>
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * 注意，|val| 表示 val 的绝对值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个 1 ，但我们只应返回不同的数对的数量。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5) 。
 * 示例 3：
 * <p>
 * 输入：nums = [1, 3, 1, 5, 4], k = 0
 * 输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 * 思路：先将数组里的数，都放到hash表中，可去重，
 * 然后遍历数组，取当前数+k,判断在hash表中有没有
 * <p>
 * 关键点：如何去重
 * <p>
 * 保存hash表的时候记录一下次数，如果当前数对应的value 为0 ，这就不处理了，
 */
public class FindPairs_532 {

    public static void main(String[] args) {
        FindPairs_532 pairs = new FindPairs_532();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(pairs.findPairs2(nums, 1));

    }

    public int findPairs(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Set<Integer> res = new HashSet<>();
        // 再次遍历数组，寻找nums[i]+k 的值
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            /**
             * 1、hash表有相加的值
             * 2、加的值小标和当前值的下标不能相等
             * 3、重复的数对，只保留一个
             */
            if (map.containsKey(n + k) &&
                    !map.get(n + k).equals(i)) {
                res.add(n);
            }

        }
        return res.size();
    }

    /**
     * 参考题解优化
     * 题意的中的绝对值可以用了
     * 1、遍历一次数组，直接将当前数的-k的值和+k的值，放到目标hash表，
     * 最后统计目标hash的大小
     * 相当于直接去重了数对，
     * 如3-2 = 1和 1+2 = 3 , 可算作一个
     */
    public int findPairs1(int[] nums, int k) {

        Set<Integer> visited = new HashSet<>();
        // 统计的是满足的数对之间的和值或者差值
        Set<Integer> res = new HashSet<>();
        // 再次遍历数组，寻找nums[i]+k 的值

        for (int i = 0; i < nums.length; i++) {
            /**
             * 代码实现时，由于 kk 是定值，知道数对的较小值，也就知道了另一个值，
             * 因此我们可以只将数对的较小值放入 \textit{res}res，而不影响结果的正确性
             */
            if (visited.contains(nums[i] - k)) {
                res.add(nums[i] - k);
            }
            if (visited.contains(nums[i] + k)) {
                res.add(nums[i]);
            }
            visited.add(nums[i]);

        }
        return res.size();
    }

    /**
     * 排序+双指针
     * 判断相邻两个数的差值或者和值是否是k
     * <p>
     * 1 1 3 4 5
     */
    public int findPairs2(int[] nums, int k) {


        // 升序排序
        Arrays.sort(nums);
        int n = nums.length;
        int b = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {

            // 考虑临界值，如果两个数相等，只需要处理一个就行
            // 第一个的时候处理，后面的要跟前一个数进行比对
            // 这个判断，就忽略了，重复的数据对
            if (i == 0 || nums[i] != nums[i-1]){
                int num1 = nums[i] + k;
                /**
                 *  找数的一些边界条件
                 *  i 和 b的下表不能相等，因为是排序过的索引，
                 *  nums[y] < nums[i] +k
                 */
                while (b < n && (nums[b] < num1 || b <= i)){
                    b++;
                }
                if (b < n && nums[b] == num1) {
                    ans++;
                }
            }

        }


        return ans;
    }
}
