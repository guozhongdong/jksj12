package com.gzd.leetcode.greed;

/**
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，
 * 也可能是空的。
 * <p>
 * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，
 * 与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 * <p>
 * 给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，
 * 请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。
 * 如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：machines = [1,0,5]
 * 输出：3
 * 解释：
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 * 第三步:    2     1 <-- 3    =>    2     2     2
 * 示例 2：
 * <p>
 * 输入：machines = [0,3,0]
 * 输出：2
 * 解释：
 * 第一步:    0 <-- 3     0    =>    1     2     0
 * 第二步:    1     2 --> 0    =>    1     1     1
 * 示例 3：
 * <p>
 * 输入：machines = [0,2,0]
 * 输出：-1
 * 解释：
 * 不可能让所有三个洗衣机同时剩下相同数量的衣物。
 *  
 * <p>
 * 提示：
 * <p>
 * n == machines.length
 * 1 <= n <= 104
 * 0 <= machines[i] <= 105
 * <p>
 * 思路：求和，除以洗衣机数，小于这个数的，按分配的数量减去，就是目标数
 *
 * 一定可以操作m个洗衣机
 *
 * 题解没看懂
 *
 *
 */
public class FindMinMoves_517 {

    public static void main(String[] args) {

    }

    public int findMinMoves(int[] machines) {


        int sum = 0;
        int n = machines.length;
        for (int i = 0; i < n; i++) {
            sum += machines[i];
        }

        if (sum % n != 0) {
            return -1;
        }
        int count = sum / n;
        int res = 0;
        int ns = 0;
        for (int i = 0; i < n; i++) {
            machines[i] -= count;
            ns += machines[i];
            res = Math.max(res,Math.max(Math.abs(ns),machines[i]));

        }
        return res;

    }
}
