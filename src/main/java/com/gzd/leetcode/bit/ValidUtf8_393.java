package com.gzd.leetcode.bit;

/**
 * 给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。
 * <p>
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 * <p>
 * 对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 * 对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，
 * 后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 * 这是 UTF-8 编码的工作方式：
 * <p>
 * Number of Bytes  |        UTF-8 octet sequence
 * |              (binary)
 * --------------------+---------------------------------------------
 * 1          | 0xxxxxxx
 * 2          | 110xxxxx 10xxxxxx
 * 3          | 1110xxxx 10xxxxxx 10xxxxxx
 * 4          | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * x 表示二进制形式的一位，可以是 0 或 1。
 * <p>
 * 注意：输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：data = [197,130,1]
 * 输出：true
 * 解释：数据表示字节序列:11000101 10000010 00000001。
 * 这是有效的 utf-8 编码，为一个 2 字节字符，跟着一个 1 字节字符。
 * 示例 2：
 * <p>
 * 输入：data = [235,140,4]
 * 输出：false
 * 解释：数据表示 8 位的序列: 11101011 10001100 00000100.
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个 3 字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= data.length <= 2 * 104
 * 0 <= data[i] <= 255
 * <p>
 * 思路：通过第一个数字判断它是一个几字节的字符，然后响应的往后面找，具有编码规律的字节
 * 考虑边界条件
 * 一个字符 0 开头，
 * 高位1的数量怎么求？
 * 1、string 的api？
 */
public class ValidUtf8_393 {

    public static void main(String[] args) {
        ValidUtf8_393 urft8 = new ValidUtf8_393();
        int[] data = {197,130,1};
        //System.out.println(urft8.validUtf8(data));
        System.out.println(urft8.validUtf82(data));
        System.out.println(Integer.toBinaryString(145));
    }

    /**
     * 2^7 == 10000000
     * 2^6 = 1000000
     * 相加 1100 0000 与 10 00 0000 ，判断是否等于 2^7
     * <p>
     * 1、求1的长度
     * 1000 0000 与 num 如果不等于0 ，则计算1的个数
     * num = 0000 0001
     * num = 1100 0001
     * <p>
     * <p>
     * 2、判断前两位是不是10
     * 3、
     */

    private int MASK1 = 1 << 7;
    private int MASK2 = (1 << 7) + (1 << 6);

    public boolean validUtf8(int[] data) {

        int m = data.length;
        int index = 0;
        while (index < m) {
            int num = data[index];
            // 字节数
            int n = getBytes(num);
            // getBytes 考虑n的几种不符合场景
            if (n < 0 || index + n > m) {
                return false;
            }
            // 判断字节后面的数，符合不符合
            for (int i = 1; i < n; i++) {
                // 每一个数前两位必须是10
                if (!isValid(data[index + i])) {
                    return false;
                }
            }
            // 过滤当前已经使用的数
            index += n;
        }

        return true;
    }

    private int getBytes(int num) {
        // 只要num的前两位不是1，这个接口肯定是0
        if ((num & MASK1) == 0) {
            return 1;
        }
        // 通过右移依然可以计算高位1的个数
        int n = 0;
        int mask = MASK1;
        // 1110 0001
        // 1000 0000,0100 0000 ,0010 0000,0001 0000
        // 1001 0001 1001 0001  1001 0001 1001 0001
        while ((num & mask) != 0) {
            n++;
            if (n > 4) {
                return -1;
            }
            mask = mask >> 1;
        }

        return n;
    }

    private boolean isValid(int num) {
        return (num & MASK2) == MASK1;
    }


    public boolean validUtf82(int[] data) {

        int n = 0;
        for (int i = 0; i < data.length; i++) {
            if (n == 0) {
                int num = data[i];
                if ((num >> 5) == 0b110) {
                    n = 1;
                } else if ((num >> 4) == 0b1110) {
                    n = 2;
                } else if ((num >> 3) == 0b11110) {
                    n = 3;
                }else if ((num >> 7) == 0b1){
                    return false;
                }
            } else {

                if ((data[i] >> 6) == 0b10) {
                    n--;
                } else {
                    return false;
                }
            }
        }
        return n == 0;
    }
}
