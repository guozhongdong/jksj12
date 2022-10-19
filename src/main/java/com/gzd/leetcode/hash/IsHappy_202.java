package com.gzd.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * <p>
 * <p>
 * 边界点：
 * 1、小于10，并且不是1，肯定false，直接退出
 * 2、计算这个整数的各个位置的数字，组装成下个数字
 */
public class IsHappy_202 {

    public static void main(String[] args) {

        IsHappy_202 happy = new IsHappy_202();
        System.out.println(happy.isHappy(2));

    }

    /**
     * 投机取巧法
     * 如何知道1 和 7 是快乐数呢
     */
    public boolean isHappy(int n) {
        if (n == 1 || n == 7) {
            return true;
        }
        if (n < 10) {
            return false;
        }
        // 计算数字的各个平方和
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return isHappy(sum);


    }


    /**
     * 使用hash表，保存计算过的快乐数
     * 如果出现无线循环，必然会出现相同的数（这个如何推导的？）
     * <p>
     * 三位数字的最大是 999 ，最大平方是 243
     * 推导了三位以上的数字，最终会降到三位一下，不会出现无限大的场景（）
     * 对于 33 位数的数字，它不可能大于 243243。这意味着它要么被困在 243243 以下的循环内，
     * 要么跌到 11。44 位或 44 位以上的数字在每一步都会丢失一位，直到降到 33 位为止。所以我们知道，
     * 最坏的情况下，算法可能会在 243243 以下的所有数字上循环，然后回到它已经到过的一个循环或者回到 11。
     * 但它不会无限期地进行下去，所以我们排除第三种选择。
     * <p>
     * 即使在代码中你不需要处理第三种情况，你仍然需要理解为什么它永远不会发生，这样你就可以证明为什么你不处理它。
     */
    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 0 && !set.contains(n)) {
            set.add(n);
            n = getNum(n);
        }
        return n == 1;
    }

    private int getNum(int n) {

        // 计算数字的各个平方和
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    /**
     * 快慢指针法
     * 参考检测链表是否有环
     * 如果优化，则不是快乐树
     * 如果没有话，则快指针肯定先到达1
     */
    public boolean isHappy12(int n) {
        int slow = n;
        int fast = getNum(n);
        while (fast != 1 && slow != fast) {
            slow = getNum(slow);
            fast = getNum(getNum(fast));
        }
        return fast == 1;
    }


}
