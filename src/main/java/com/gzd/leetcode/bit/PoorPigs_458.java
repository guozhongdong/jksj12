package com.gzd.leetcode.bit;


/**
 * 有 buckets 桶液体，其中 正好有一桶 含有毒药，其余装的都是水。它们从外观看起来都一样。为了弄清楚哪只水桶含有毒药，你可以喂一些猪喝，通过观察猪是否会死进行判断。不幸的是，你只有 minutesToTest 分钟时间来确定哪桶液体是有毒的。
 * <p>
 * 喂猪的规则如下：
 * <p>
 * 选择若干活猪进行喂养
 * 可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。
 * 小猪喝完水后，必须有 minutesToDie 分钟的冷却时间。在这段时间里，你只能观察，而不允许继续喂猪。
 * 过了 minutesToDie 分钟后，所有喝到毒药的猪都会死去，其他所有猪都会活下来。
 * 重复这一过程，直到时间用完。
 * 给你桶的数目 buckets ，minutesToDie 和 minutesToTest ，返回 在规定时间内判断哪个桶有毒所需的 最小 猪数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：buckets = 1000, minutesToDie = 15, minutesToTest = 60
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：buckets = 4, minutesToDie = 15, minutesToTest = 15
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：buckets = 4, minutesToDie = 15, minutesToTest = 30
 * 输出：2
 *  
 * <p>
 * 基本思路：数学归纳
 * 通过猪和次数，反推能找到桶的个数
 */
public class PoorPigs_458 {

    public static void main(String[] args) {


        PoorPigs_458 poorPigs = new PoorPigs_458();
        System.out.println(poorPigs.poorPigs(125, 1, 4));
        System.out.println(poorPigs.poorPigs1(125, 1, 4));
        System.out.println(Math.log(125) / Math.log(5) - 1e-5);
        System.out.println(Math.log(5));
    }

    /**
     * 求对数
     * 先列举一只小猪能验证的桶数
     * 接着是大于1的时候
     * <p>
     * pow(次数, 猪) = 桶
     * <p>
     * 2个猪，5次机会，可以找25个桶
     * <p>
     * <p>
     * le-5 科学计数法，标识的位数， 10^(-5) = 0.00001
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int bases = minutesToTest / minutesToDie + 1;
        double zhu = Math.log(buckets) / Math.log(bases) - 1e-5;
        int res = (int) Math.ceil(zhu);
        return res;
    }

    public int poorPigs1(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie;
        int base = times + 1;
        // base ^ ans >= buckets
        // ans >= log(buckets) / log(base)
        double temp = Math.log(buckets) / Math.log(base) - 1e-5;
        int ans = (int) Math.ceil(temp);
        return ans;
    }

}
