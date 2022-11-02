package com.gzd.leetcode.greed;

/**
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
 * 思路：按层遍历，先外层，然后内层，直到边界值都相等了，
 *
 * 1、水平翻转，对角线翻转
 *
 * 7 8 9
 * 4 5 6
 * 1 2 3
 *
 */
public class Rotate_48 {

    public static void main(String[] args) {
        Rotate_48 rotate = new Rotate_48();
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        rotate.rotate(nums);

    }

    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;


        // 水平对角线翻转，处理一半的数据即可
        // 如 n*n  n = 3 n=1是对角线 0 和 2 的指对换
        for (int i = 0; i < m/2; i++) {
            for (int j = 0; j < n; j++) {
                // 对角线上面的元素
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m-i-1][j];
                matrix[m-i-1][j] = temp;
            }
        }
        // 45度对角线翻转 i和j相等的不动，属于对角线
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

    }
}
