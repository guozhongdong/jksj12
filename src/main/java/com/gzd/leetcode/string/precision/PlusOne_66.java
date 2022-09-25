package com.gzd.leetcode.string.precision;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * 考虑边界值问题
 * 99 + 1
 * 数组的长度变长
 * 不考虑边界值：
 * 现将输入数组转换为数字，则相加
 * 相加完转换成字符串，存入新数组
 *
 * @author guozhongdong
 */
public class PlusOne_66 {

    public static void main(String[] args) {
        PlusOne_66 one = new PlusOne_66();

        System.out.println();
        int[] nums = {2,9,8, 9, 9};
        //int[] result = one.plusOne1(nums);
        int[] result = one.plusOne2(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();
    }

    public int[] plusOne(int[] digits) {
        // 开始转成数字
        int n = digits.length;
        long sum = 0;
        int yin = n - 1;
        for (int i = 0; i < n; i++) {
            sum += digits[i] * Math.pow(10, yin);
            yin--;
        }
        sum++;
        String str = String.valueOf(sum);
        int[] newInt = new int[str.length()];
        int yin2 = str.length() - 1;
        int count = 0;
        while (sum != 0) {
            newInt[count++] = (int) ((int) sum / Math.pow(10, yin2));
            sum = (long) (sum % Math.pow(10, yin2));
            yin2--;
        }

        return newInt;
    }

    public int[] plusOne1(int[] digits) {
        // 开始转成数字
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        int jinzhi = 1;
        String yuan = sb.toString();
        StringBuilder sb1 = new StringBuilder();
        // 279  --- 280
        int count = yuan.length() - 1;
        // 999
        // 2999
        // 29899
        while (count >= 0) {
            int n1 = Character.digit(yuan.charAt(count), 10);
            // 处理个位上数
            if (n1 + jinzhi > 9) {
                sb1.append(0);
            } else {
                sb1.append(n1 + jinzhi);
                jinzhi = 0;
            }
            count--;
        }
        if (jinzhi > 0) {
            sb1.append(1);
        }

        String str = sb1.toString();
        int[] newInt = new int[str.length()];
        for (int i = str.length()-1; i >= 0; i--) {
            Character c = str.charAt(i);
            newInt[i] = Character.digit(c, 10);
        }

        return newInt;
    }


    /**
     * 优化2 ，不使用外部空间，直接在原数组上改，
     *
     * 从后面的开始判断，是9 还是非9,9的需要进位，继续循环，非9的话，直接加1结束
     */
    public int[] plusOne2(int[] digits) {
        // 开始转成数字
        for (int i = digits.length-1; i >=0 ; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            // 如果不为0，说明加1之后，没超过9,直接返回
            if (digits[i] != 0){
                return digits;
            }
        }
        // 如果整个循环里都没跳出去，可能出现了极端情况999
        digits = new int[digits.length+1];
        // 首位置补1
        digits[0] = 1;
        return digits;
    }
}
