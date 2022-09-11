package com.gzd.leetcode.array;

/**
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，
 * 则将其所在行和列的所有元素都设为 0 。
 * 请使用 原地 算法。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 *
 * 思路：正常遍历，如果遇到0，先把当前的行下标，置为0，然后遍历到边长，
 * 然后再把 
 *
 * @author guozhongdong
 */
public class SetZeroes_73 {

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,0},{7,8,9}};
        SetZeroes_73 setZeroe = new SetZeroes_73();
        setZeroe.setZeroes(nums);
        System.out.println("");
    }


    /**
     * 使用常量的空间
     * 不用额外空间，用几个变量能不能记录到0的位置呢？？？
     *
     * 使用矩阵的第一行和第一列作为标记数组，解法二的参考
     * 使用两个变量，记录第一行和第一列是否有0，
     * 先拿第一行和第一列去更新其他数组，
     * 最后再根据标记变量来更新第一行和第一列
     *
     * 核心点：如果其他行列出现0, 第一行和第一列对应的值肯定也是0
     *
     *
     */
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowFlag = false;
        boolean colFlag = false;
        // 判断第一行
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0){
                rowFlag = true;
            }
        }

        // 判断第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0){
                colFlag = true;
            }
        }

        // 循环其他行列里面da带0的标识
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        /**
         * 根据第一行和第一列存的0值，将对应的行列变为0
         * 如果第一行的最后一列是0，则标识整个矩阵的最后一列都是0
         * 意思第一行或第一列 占一个下标，相对应的下标都更新
         *
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] ==0){
                    matrix[i][j] = 0;
                }
            }
        }
        // 更新第一行和第一列
        if (rowFlag){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }


    }

    /**
     * 使用m*n的额外空间
     *
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 记录要为0的行小标
        int[] rowNum = new int[m];
        // 记录要为0的列下标
        int[] colNum = new int[n];
        /// 这一次遍历是将要置为0的行下标记录下
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    rowNum[i] = 1;
                    colNum[j] = 1;
                }

            }
        }
        // 将原数组相应的行和列置为0
        for (int i = 0; i < m; i++) {
            if (rowNum[i] == 1){
                int n1 = 0;
                while (n1 < n){
                    matrix[i][n1] = 0;
                    n1++;
                }

            }
            for (int j = 0; j < n; j++) {
                if (colNum[j] == 1){
                    int n1 = 0;
                    while (n1 < m){
                        matrix[n1][j] = 0;
                        n1++;
                    }

                }
            }
        }

    }


    /**
     * 使用m+n的额外空间
     *
     */
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] temp = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    // 特殊处理
                    int t = 0;
                    int t1 = 0;
                    while (t < n){
                        temp[i][t] = 0;
                        t++;
                    }
                    while (t1 < m){
                        temp[t1][j] = 0;
                        t1++;
                    }
                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }

    }

}
