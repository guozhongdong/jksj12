package com.gzd.leetcode.bit;


import java.util.Arrays;

/**
 * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭第二个。
 * <p>
 * 第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
 * <p>
 * 找出并返回 n 轮后有多少个亮着的灯泡。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：1
 * 解释：
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 * <p>
 * 你应该返回 1，因为只有一个灯泡还亮着。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 109
 * <p>
 * 利用二进制的性质
 * n 代表n个二进制位
 * n=4
 * 0000
 * 1轮  1111
 * 2轮  1010
 * 3轮  1000
 * 4轮  1001
 */
public class BulbSwitch_319 {

    public static void main(String[] args) {
        BulbSwitch_319 switch1 = new BulbSwitch_319();
        System.out.println(switch1.bulbSwitch(5));
    }

    public int bulbSwitch(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        // 轮数
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < nums.length ; j+=i) {
                if (i+j-1 < nums.length){
                    nums[i+j-1] = nums[i+j-1] ==1 ? 0 : 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                count++;
            }
        }
        return count;
    }
}
