package com.gzd.leetcode.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 * <p>
 * 排序+贪心
 * [[1,2],[2,3],[3,4],[1,3]]
 * [1,2] [1,3] [2,3] [3,4]
 * <p>
 * 判断后一个区间的左端值，是否在前一个区间
 */
public class EraseOverlapIntervals_435 {

    public static void main(String[] args) {
        EraseOverlapIntervals_435 intervals = new EraseOverlapIntervals_435();
        int[][] nums = {{1,2},{1,2},{1,2},{1,2}};
        System.out.println(intervals.eraseOverlapIntervals(nums));
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int ans = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        // [1,100] [11,22] [1,11] [2,12]
        // {0,2},{1,3},{2,4},{3,5},{4,6}
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= start && intervals[i][0] < end) {
                ans++;
                start = Math.max(intervals[i][0],start);
                end = Math.min(end, intervals[i][1]);
            }else {
                start = intervals[i][0];
                end = intervals[i][1];
            }

        }
        return ans;
    }
}
