package com.gzd.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，
 * 用一个数组返回这个矩阵中的所有元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 *  
 * 越是数据模型看着复杂的题，越是有一定的解题规律
 * <p>
 * 0 0 ，0 1 ，0 2
 * 1 0 ，1 1 ，1 2
 * 2 0,  2,1  2 2
 * <p>
 * <p>
 * 思路：找对角线的规律，发现每条线的规律是两个坐标之和都是相等的
 * 然后在找到起始坐标以哪个轴为最大
 * <p>
 * 奇数躺是 行坐标从小到大，列坐标从大到小,x 尽可能取最大值，
 * 终止条件是 x==0,期间还要考虑y的上限，y不能超过上限
 * <p>
 * 偶数躺 行坐标从大到小，列坐标从小到大
 * <p>
 * x
 * y
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 *
 * @author guozhongdong
 */
public class FindDiagonalOrder_498 {


    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        FindDiagonalOrder_498 order = new FindDiagonalOrder_498();
        //order.findDiagonalOrder(nums);
        order.findDiagonalOrder1(nums);
    }

    public int[] findDiagonalOrder(int[][] mat) {


        int x = mat.length;
        int y = mat[0].length;
        int[] result = new int[x * y];
        List<Integer> list = new ArrayList<>();
        // 变量i 定义一趟
        int i = 0; // x+y的和
        // 总趟数
        int count = 0;
        while (i < x + y) {

            int m = (i < x) ? i : x - 1;
            int x1 = m;
            int y1 = i - x1;
            while (x1 >= 0 && y1 < y) {
                result[count++] = mat[x1][y1];
                x1--;
                y1++;
            }
            // 加一趟
            i++;
            if (i > x + y) {
                break;
            }
            // 尽可能的给y取最大值
            int n = (i < y) ? i : y - 1;
            y1 = n;
            x1 = i - y1;
            while (y1 >= 0 && x1 < x) {
                result[count++] = mat[x1][y1];
                x1++;
                y1--;
            }
            i++;

        }
        return result;
    }

    // 优化
    public int[] findDiagonalOrder1(int[][] mat) {


        int x = mat.length;
        int y = mat[0].length;
        int[] result = new int[x * y];

        // 变量i 定义一趟
        // 标识奇偶趟
        boolean flag = true;
        int i = 0; // x+y的和
        // 总趟数
        int count = 0;
        while (i < x + y) {

            // 奇数
            int pm = flag ? x : y;
            // 偶数
            int pn = flag ? y : x;
            int x1 = i < pm ? i : pm - 1;
            int y1 = i - x1;

            while (x1 >= 0 && y1 < pn) {
                result[count++] = flag ? mat[x1][y1] : mat[y1][x1];
                x1--;
                y1++;

            }
            // 加一趟
            i++;
            flag = !flag;

        }
        return result;
    }
}
