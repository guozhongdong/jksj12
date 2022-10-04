package com.gzd.leetcode.bit;

/**
 * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 所以，现给定一个具体的矩形页面面积，
 * 你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 * <p>
 * 你设计的矩形页面必须等于给定的目标面积。
 * 宽度 W 不应大于长度 L ，换言之，要求 L >= W 。
 * 长度 L 和宽度 W 之间的差距应当尽可能小。
 * 返回一个 数组 [L, W]，其中 L 和 W 是你按照顺序设计的网页的长度和宽度。
 *  
 * <p>
 * 示例1：
 * <p>
 * 输入: 4
 * 输出: [2, 2]
 * 解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
 * 但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
 * 示例 2:
 * <p>
 * 输入: area = 37
 * 输出: [37,1]
 * 示例 3:
 * <p>
 * 输入: area = 122122
 * 输出: [427,286]
 * <p>
 * 思路：开方，一个向上取整 一个向下取整
 */
public class ConstructRectangle_492 {

    public static void main(String[] args) {
        ConstructRectangle_492 angle = new ConstructRectangle_492();
        System.out.println(Math.sqrt(5));
        int[] res = angle.constructRectangle(37);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    /**
     * 执行结果
     * 52 / 52 个通过测试用例
     * 状态：通过
     * 执行用时: 19 ms
     * 内存消耗: 39.1 MB
     *
     */
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        if (area == 1) {
            res[0] = 1;
            res[1] = 1;
            return res;
        }
        int l = (int) Math.ceil(Math.sqrt(area));
        int w = (int) Math.floor(Math.sqrt(area));
        int l1 = l;
        while (l1 <= area && w >= 1) {
            if (l1 * w == area) {
                res[0] = l1;
                res[1] = w;
                return res;
            }
            if (l1 * w > area) {
                w--;
            } else {
                l1++;
            }
        }
        return null;
    }


    /**
     * 参考题解优化方法
     * 开方之后，直接求余，如果等于0了，说明是个完全平方数，
     * 如果不等于0，让这个数一直往小了减，知道遇到一个能整除的数
     *
     * 执行结果：通过
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了15.16%的用户
     * 通过测试用例：52 / 52
     */
    public int[] constructRectangle1(int area) {

        int w = (int) Math.floor(Math.sqrt(area));
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};
    }
}
