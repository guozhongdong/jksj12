package com.gzd.leetcode.array;

/**
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *  
 *
 * 提示：
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *  
 * 思路：找规律找错了，题解是直接按行到列，我这边按元素找规律，偏远了
 * 没找到公式，瞎循环
 *
 *
 * 题解1：
 * 使用额外数据空间
 * 第一行的旋转后变成 n列
 * 第二行选装后，变成 n-1列
 * ......
 * m是行  n是列
 * 重点是能找到转换后的对应公式，有助于理解后续两种解法
 * 1 2 3   变成 matrix[0][0] = matrix[0][2];
 *            matrix[0][1] = matrix[1][2];
 *            matrix[0][2] = matrix[2][2];
 *
 *            matrix[row][col] = matrix[col][n-row-1];
 *
 *
 *       1
 *       2
 *       3
 *
 *
 * @date 2022/9/9 22:23
 */
public class Rotate_48 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Rotate_48 rotate48 = new Rotate_48();
        rotate48.rotate(nums);
        System.out.println("");

    }

    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newNum = new int[m][n];

        for (int i = 0; i < matrix.length; i++) {
            int[] mat = matrix[i];
            for (int j = 0; j < mat.length; j++) {
                newNum[j][n-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] mat = matrix[i];
            for (int j = 0; j < mat.length; j++) {
                matrix[i][j] = newNum[i][j];
            }
        }


    }

    /**
     * 使用原地算法
     * 公式
     *
     *  row = col
     *  col = n-row-1
     *
     *  一个大循环
     *  matrix[col][n-row-1] = matrix[row][col];
     *  matrix[n-row-1][n-col-1] = matrix[col][n-row-1];
     *  matrix[n-col-1][row] = matrix[n-row-1][n-col-1];
     *  matrix[row][col] = matrix[n-col-1][row];
     *
     * 公式代替法牛逼
     * 类似我的第一错误思路，之后没想后面这个点
     *
     * 关键点：
     * 1、公式代入，替换值
     * 2、如何枚举需要替换的数
     * 一次循环4个点，
     *
     *
     */
    public void rotate1(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newNum = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {

        }



    }
}
