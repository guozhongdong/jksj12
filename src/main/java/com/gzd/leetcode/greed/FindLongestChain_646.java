package com.gzd.leetcode.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。
 * 我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，
 * 你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 给出数对的个数在 [1, 1000] 范围内。
 * <p>
 * 排序+贪心
 * 第一个数对的右端点数小于第二个数对的左端点数就满足
 *
 * 对数对中，第二个数进行排序，
 * 如果（a,b） (c,d)   b< c 满足在，
 * 按第二个数排序后，直接从第一个元素开始比较，遇到满足的，更新比较因子，
 * 记录满足的数对
 *
 */
public class FindLongestChain_646 {

    public static void main(String[] args) {

        FindLongestChain_646 chain = new FindLongestChain_646();
        int[][] nums = {{7, 9}, {4, 5}, {7, 9}, {-7, -1}, {0, 10}, {3, 10}, {3, 6}, {2, 3}};
        System.out.println(chain.findLongestChain(nums));
    }


    // [[-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]]
    //[[7,9],[4,5],[7,9],[-7,-1],[0,10],[3,10],[3,6],[2,3]]
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        // 先取第一个数对
        int cur = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (cur < pairs[i][0]) {
                cur = pairs[i][1];
                res++;
            }
        }
        return res;
    }

}
