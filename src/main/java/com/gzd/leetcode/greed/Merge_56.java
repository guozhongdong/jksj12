package com.gzd.leetcode.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * 贪心算法
 * 期望返回一个新的取件，覆盖原来的区间
 * <p>
 * 判断下一个区间的最小值是否比上一个区间的最大值小或者相等，如果小的话，就合并
 * <p>
 * 做不出来
 */
public class Merge_56 {

    public static void main(String[] args) {
        Merge_56 merge = new Merge_56();
        int[][] nums = {{1, 1}, {2, 3}, {4, 5}, {5, 7}, {7, 9}};
        merge.merge(nums);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][2];
        }
        // 这个自定义排序，得想到，按左端点从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            // 如果是第一次添加至或者当前的左端点，比上一个区间的右端点大，直接把当前元素添加进来
            if (list.size() == 0 || list.get(list.size()-1)[1] < L){
                list.add(new int[]{L,R});
            }else {
                // 更新右端前，取出集合中的最后一个右端点，与当前取得值得右端点进行比较
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],R);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
