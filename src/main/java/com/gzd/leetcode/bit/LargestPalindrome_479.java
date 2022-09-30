package com.gzd.leetcode.bit;

/**
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。
 * 因为答案可能非常大，所以返回它对 1337 取余 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：n = 2
 * 输出：987
 * 解释：99 x 91 = 9009, 9009 % 1337 = 987
 * 示例 2:
 * <p>
 * 输入： n = 1
 * 输出： 9
 * <p>
 * 思路：1、先找出对应n位的最大数字
 * 2、判断回文
 * 3、判断是否大于1337
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 8
 *
 * @author guozhongdong
 * @date 2022/9/28 11:38
 */
public class LargestPalindrome_479 {

    public static void main(String[] args) {
        LargestPalindrome_479 rome = new LargestPalindrome_479();
        System.out.println(90909 % 1337);
        System.out.println(rome.largestPalindrome(5));
    }

    /**
     * n代表目标数字的位数
     * 先确定n*n的乘积的位数
     * 99*99 = 9801
     * 乘积2n，n=2的话，是四位 9999
     * 因为是回文串，直接构造出整个数nums
     * 在判断两个两位数的乘积 是不是比这个回文大，不大的，直接跳过，找下个回文
     * 如果大的话，直接
     *
     *
     * 然后拿nums 除 j,看能不能得到整数，得到了，则说明他是最大的
     * 如果是回文串的，可以先枚举左半部分
     */
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        //找到最大数
        int max = (int) (Math.pow(10, n) - 1);
        for (int i = max; i >= 0; i--) {
            // 找到以i为左半部分的最大回文串
            // 为啥计算回文，要以这个两位数为前缀呢，四位数的前两位也是个两位数
            long num = i;
            long n2 = i;
            while (n2 != 0) {
                num = num * 10 + n2 % 10;
                n2 = n2 / 10;
            }

            // 上面循环出来了，num 就是一个回文串，且是最大的，
            // 下面判断，当前i位置的数，能不能为num整除，
            for (long j = max; j * j >= num; j--) {
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return -1;

    }

    private boolean isHuiWen(int n) {
        if (n % 10 == 0 && n >= 10) {
            return false;
        }
        int res = 0;
        while (n > res) {
            res = res * 10 + n % 10;
            n = n / 10;
        }
        return n == res || n == res / 10;
    }

}
