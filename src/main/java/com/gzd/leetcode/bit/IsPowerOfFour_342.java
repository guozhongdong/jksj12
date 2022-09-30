package com.gzd.leetcode.bit;

/**
 *
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；
 * 否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *
 * 进阶：你能不使用循环或者递归来完成本题吗？
 *
 *
 * 参考 231题，计算2的幂次方
 * 直接按二进制判断
 * 1     0001
 *       1000  0010
 * 4     100   001
 * 16   10000  100 = 10000
 * 64 1000000  10000
 * 256
 *
 * 与 或 非
 * 4进制
 *
 *
 * @author guozhongdong
 * @date 2022/9/28 21:36
 */
public class IsPowerOfFour_342 {

    public static void main(String[] args) {
        IsPowerOfFour_342 ofFour = new IsPowerOfFour_342();

        System.out.println(8 % 3);
        System.out.println(ofFour.isPowerOfFour(8));
        System.out.println(ofFour.isPowerOfFour1(8));
    }

    public boolean isPowerOfFour(int n) {
        if (n == 1){
            return true;
        }
        // 2的偶次幂 满足了2
        // 如何让8不满足 1000 它不是4的次幂，
        // 10000

        // 2的奇数次幂，是不满足的


        // 看题解，直接枚举了，2^31 范围所有偶数次幂的1
        // 100100100
        return n >= 1 && (n & (n - 1)) == 0 && ((n & (0xaaaaaaaa)) ==0);
    }
    public boolean isPowerOfFour1(int n) {
        if (n == 1){
            return true;
        }
        //经验之谈
        // 4^2 = (3+1)^2 = 3^2 +1;
        // 所以4的幂次方，模上3，余数肯定是1
        return n >= 4 && (n & (n - 1)) == 0 && n % 3 ==1;
    }
}
