package com.gzd.leetcode.bit;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：n = 45
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 *  
 * <p>
 * 进阶：你能不使用循环或者递归来完成本题吗？
 * 2的幂
 * 4的幂
 * 3的幂
 * <p>
 * 9  8+1     1001
 * 27 16+11    11011
 * 51 32+19   110011
 * 153 128 + 25
 *
 * @author guozhongdong
 * @date 2022/9/28 22:07
 */
public class IsPowerOfThree_326 {

    public static void main(String[] args) {
        IsPowerOfThree_326 ofThree = new IsPowerOfThree_326();
        System.out.println(ofThree.isPowerOfThree(9));
    }


    /**
     * (3+1)^n = 4^n
     * 3^n + 1 + 2 * 3 = 4^n -7
     * <p>
     * n + 1 +  3 * n = 4 ^ n
     * <p>
     * <p>
     * n >= 4 && (n & (n - 1)) == 0 && n % 3 ==1;
     */
    public boolean isPowerOfThree(int n) {
        if (n < 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n ==1 ;
    }
}
