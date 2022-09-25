package com.gzd.leetcode.string.digit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，
 * 找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= timePoints.length <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 * <p>
 * 将字符格式的时间转为为分钟数字，直接减
 * (需要考虑一个首尾时间差)
 *
 * @author guozhongdong
 */
public class FindMinDifference_539 {

    public static void main(String[] args) {
        FindMinDifference_539 difference = new FindMinDifference_539();
        List<String> list = new ArrayList<>();


        /*System.out.println(23*60+59);
        System.out.println(24*60);*/
        //["05:31","22:08","00:35"]
        list.add("05:31");
        list.add("22:08");
        list.add("00:35");

        System.out.println(difference.findMinDifference(list));
    }

    public int findMinDifference(List<String> timePoints) {

        // 鸽巢原理,预判重复值
        if (timePoints.size() > 1440){
            return 0;
        }
        // 转换时间数组
        int[] fen = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            if (s.equals("00:00")) {
                fen[i] = 24 * 60;
                continue;
            }
            String[] str = s.split(":");
            fen[i] = 60 * Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
        }
        Arrays.sort(fen);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < fen.length; i++) {
            int n = fen[i] - fen[i - 1];
            min = Math.min(min, n);
        }
        // 计算一个特殊值，首尾时间差
        min = Math.min(min, fen[0] + 1440 - fen[fen.length - 1]);
        return min;
    }


}
