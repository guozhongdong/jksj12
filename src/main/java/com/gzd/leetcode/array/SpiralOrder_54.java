package com.gzd.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * 思路：暴力解法，注意边界值的判断
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @author guozhongdong
 */
public class SpiralOrder_54 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,4}, {5, 6, 7,8}, {9, 10, 11,12}};
        SpiralOrder_54 order = new SpiralOrder_54();
        System.out.println(order.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        // 维护两个变量，分别代表行和列
        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return  list;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bootle = matrix.length - 1;

        // 总判断条件
        while (top <= bootle && left <= right){

            // 从左到右遍历
            int[] nums = matrix[top];
            for (int i = left; i <= right ; i++) {
                list.add(nums[i]);
            }
            // 从右侧 从上到下遍历
            for (int i = top+1; i <= bootle ; i++) {
                list.add(matrix[i][right]);
            }
            if (left < right && top < bootle){
                // 从右到左
                int[] nums1 = matrix[bootle];
                for (int i = right-1; i >= left+1 ; i--) {
                    list.add(nums1[i]);
                }
                // 从下到上
                for (int i = bootle; i >= top+1 ; i--) {
                    list.add(matrix[i][left]);
                }
            }
            top++;
            bootle--;
            right--;
            left++;
        }

        return list;

    }
}
