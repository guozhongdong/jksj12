package com.gzd.leetcode.array;

/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同
 * （r x c）的新矩阵，但保留其原始数据。
 * <p>
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，
 * 分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * <p>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * <p>
 * 思路：
 * 1、根据R和c的大小，判断是否和原矩阵的大小相等
 * 2、遍历操作，按行遍历
 *
 * @author guozhongdong
 */
public class MatrixReshape_566 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        MatrixReshape_566 shape = new MatrixReshape_566();
        //int[][] result = shape.matrixReshape(nums, 1, 4);
        int[][] result1 = shape.matrixReshape1(nums, 1, 4);
        System.out.println("");
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        // 判断元素是否相等
        if ((r * c) != (m * n)) {
            return mat;
        }
        int[][] newNum = new int[r][c];
        int r0 = 0;
        int c0 = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] m1 = mat[i];
            for (int j = 0; j < m1.length; j++) {
                newNum[r0][c0] = mat[i][j];
                // 如果列没满，则列+1 继续，如果满了，行+1，了为0
                if (c0 < c - 1) {
                    c0++;
                } else {
                    r0++;
                    c0 = 0;
                }
            }
        }

        return newNum;
    }

    /**
     * 官方题解优化
     * 思路：将m*n的二位数组压扁，在将它还原成r*c的矩阵
     * n 是列数
     *
     * 这个公式很秒
     * (2,2) n=2
     *
     * 计算下标的公式 x = (i,j) = i*n+j; 0,1,2,3
     * <p>
     * (1,4) c=4
     * 还原:
     * x = (x/c, x%c) (0,1) (0,2) (0,3) (0,4)
     */
    public int[][] matrixReshape1(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        // 判断元素是否相等
        if ((r * c) != (m * n)) {
            return mat;
        }
        int[][] newNum = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            int[] m1 = mat[i];
            for (int j = 0; j < m1.length; j++) {
                int x = i * n + j;
                newNum[x / c][x % c] = mat[i][j];
            }
        }

        return newNum;
    }

}
