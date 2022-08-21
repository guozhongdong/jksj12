package com.gzd.jksj.algo.decursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 走台阶问题，一次走一步，或者走两步
 *
 * @author guozhongdong
 */
public class StepDemo {

    static Map<Integer, Integer> map = new HashMap<>();

    /**
     * 查询有多少种方式走台阶
     */
    public static int step(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // 需要考虑执行数据较大的话，存在重复计算的问题
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int sum = step(n - 1) + step(n - 2);
            map.put(n, sum);
            return sum;
        }
    }

    public static void main(String[] args) {

        System.out.println(step(7));
    }
}
