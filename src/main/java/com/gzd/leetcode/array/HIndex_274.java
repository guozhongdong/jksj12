package com.gzd.leetcode.array;

import java.util.Arrays;

/**
 *
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数”，一名科研人员的 h指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。
 *
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用
 * 不多于 3 次，所以她的 h 指数是 3。
 *
 * 看懂题目是关键
 * Hirsch的原始定义是，一名科学家的h指数是指其发表的Np篇论文中有h篇每篇至少被引h次、
 * 而其余Np-h篇论文每篇被引均小于或等于h次
 *
 * 排序
 *
 * @author guozhongdong
 */
public class HIndex_274 {

    public static void main(String[] args) {
        int[] nums = {3,0,6,1,5};
        HIndex_274 index = new HIndex_274();
        System.out.println(index.hIndex(nums));
    }

    public int hIndex(int[] citations) {
        if (citations == null){
            return 0;
        }
        // 排序后，从小到大
        Arrays.sort(citations);
        // 代表n篇论文
        int n = citations.length;
        // 通过n-i 判断大于h后面的数据
        int h = 0;
        // 0 1 3 5 6
        for (int i = 0; i < citations.length ; i++) {
            // 剩余的论文篇数
            h = n-i;
            // 如果i位置的数，满足h的值是小于等它的，说明i位置的数，就是满足的
            // h = citations[i]; 大于等于h的数有 n-i 个
            // 小于h的元素有 i 个(i是数组下标)
            if (h <= citations[i]){
                return h;
            }
        }

        return 0;

    }
}
