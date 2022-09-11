package com.gzd.leetcode.array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 思路：参考54题
 * 构建外层，在构建内层
 *
 * @author guozhongdong
 */
public class GenerateMatrix_59 {

    public static void main(String[] args) {

        GenerateMatrix_59 matrix59 = new GenerateMatrix_59();
        int[][] result = matrix59.generateMatrix(3);
        System.out.println();

    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottle = n - 1;
        int i = 1;
        while (left <= right && top <= bottle && i <= n * n) {
            // 从左往右
            for (int j = left; j <= right; j++) {
                matrix[top][j] = i;
                i++;
            }
            // 从上往下
            for (int j = top + 1; j <= bottle; j++) {
                matrix[j][right] = i;
                i++;
            }
            // 如果行上面，最上面的标识与最下面的标识没重复，则继续遍历
            // 列同理
            if (left < right && top < bottle) {
                //从右到左
                for (int j = right - 1; j >= left; j--) {
                    matrix[bottle][j] = i;
                    i++;
                }
                // 从下到上
                for (int j = bottle - 1; j >= top + 1; j--) {
                    matrix[j][left] = i;
                    i++;
                }
            }
            left++;
            right--;
            top++;
            bottle--;

        }

        return matrix;
    }
}
