package com.gzd.leetcode.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。
 * 每一行砖块的宽度之和相等。
 * <p>
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * <p>
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。
 * 你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * 1 2 2 1
 * 3 1 2
 * 1 3 2
 * 2 4
 * 3 1 2
 * 1 3 1 1
 * <p>
 * <p>
 * <p>
 * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：wall = [[1],[1],[1]]
 * 输出：3
 *  
 * 提示：
 * <p>
 * n == wall.length
 * 1 <= n <= 104
 * 1 <= wall[i].length <= 104
 * 1 <= sum(wall[i].length) <= 2 * 104
 * 对于每一行 i ，sum(wall[i]) 是相同的
 * 1 <= wall[i][j] <= 231 - 1
 * <p>
 * <p>
 * 从理解的题意看，
 * 只是统计每一列的砖数
 * 转换题意
 * 从通过的最小砖块数，转换为通过砖块最大的边缘数
 * 某一个列的通过的砖块边缘最多，说明经过的砖块最少
 * 拿墙的高度减去 边缘最大数
 */
public class LeastBricks_554 {

    public static void main(String[] args) {

    }

    /**
     * 1、统计每一行，各个宽度砖的个数
     */
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> r1 = wall.get(i);
            int n = r1.size();
            int sum = 0;
            for (int i1 = 0; i1 <= n - 1; i1++) {
                sum += r1.get(i1);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        // 遍历Map从map中取一个最小值
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max,entry.getValue());
        }
        return wall.size()-max;
    }
}
