package com.gzd.leetcode.greed.subarray;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，
 * 否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 *  
 * <p>
 * 提示:
 * <p>
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 * <p>
 * gas[i] 是加油站可以加的汽油
 * cost[i] 是行使到下一个加油站，需要消耗的汽油
 * 够不够行使一周
 * <p>
 * <p>
 * 存在的情况，
 * 1、gas[i] 加油站里的汽油，不够跑到下一个加油站，pass
 * 2、走了几个加油站，但是后面的不够行使一周，也不行
 * <p>
 * 环形数组
 * 遍历加油站
 * 判断每一个加油站，为出发站，够不够行使一周
 * <p>
 * 提示:
 * <p>
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 */
public class CanCompleteCircuit_134 {

    public static void main(String[] args) {

        CanCompleteCircuit_134 circuit = new CanCompleteCircuit_134();
        int[] gas = {0, 0, 0, 2};
        int[] cost = {0, 0, 1, 0};
        System.out.println(circuit.canCompleteCircuit(gas, cost));
        System.out.println(circuit.canCompleteCircuit1(gas, cost));

    }

    /**
     * 暴力解法，思路接单，需要考虑边界值
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // 一次便利
        for (int i = 0; i < gas.length; i++) {
            // 如果加油站的汽油不够行使到下一个加油站，直接pass
            if (gas[i] < cost[i] || gas[i] == 0) {
                continue;
            }
            // gas = [1,2,3,4,5], cost = [3,4,5,1,2]
            // 当前获得的汽油数
            int qi = gas[i] - cost[i];
            // 当前i位置的加油站，第一站是符合的
            int jia = i;
            // 从当前位置i出发，看能不能回到这个位置，回到就行
            while (qi >= 0) {
                // 走过i位置剩余的汽油
                // 下一个位置
                jia++;
                // i 是走过去了，达达下一个加油站剩余
                if (jia >= gas.length) {
                    jia = 0;
                }
                qi = qi + gas[jia] - cost[jia];
                if (jia == i) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * 参考题解，
     * 总体概括为，
     * 1、如果gas[i] 走过的加油站油数小于 cost[i] 那肯定是不通过
     * 2、如果
     * <p>
     * 从 x,y 之间的任何一个加油站出发，都无法到达加油站 y 的下一个加油站。
     * <p>
     * 在发现了这一个性质后，算法就很清楚了：我们首先检查第 00 个加油站，并试图判断能否环绕一周；
     * 如果不能，就从第一个无法到达的加油站开始继续检查
     * <p>
     * 一次遍历，可以过滤掉中间很多加油站
     */
    public int canCompleteCircuit1(int[] gas, int[] cost) {

        // 一次遍历
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int gasSum = 0;
            int constSum = 0;
            int cnt = 0;
            // 计数器，记录是哪个位置满足或者不满足
            while (cnt < n) {
                int j = (i + cnt) % n;
                gasSum += gas[j];
                constSum += cost[j];
                if (gasSum < constSum){
                    break;
                }
                cnt++;

            }
            // 上面的循环跳出来，说明当前i的节点符合或者不符合
            // ==n说明 cnt转了一圈了，而且右还有剩余
            if (cnt == n){
                return i;
            }else {
                // 将i直接定位不符合的位置
                i = cnt + i +1;
            }
        }

        return -1;
    }
}
