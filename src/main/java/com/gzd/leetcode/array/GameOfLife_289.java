package com.gzd.leetcode.array;

/**
 *
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970
 * 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，
 * 其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 *  输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 *
 *
 * 暴力解法：
 * 将原数组复制一份，记录每个细胞的最初状态，然后判断，最终的存活情况
 * 1、找出某个节点横 竖 对角线的点的值
 * 2、判断0和1的个数
 *
 *
 * @author guozhongdong
 */
public class GameOfLife_289 {

    public static void main(String[] args) {
        int[][] nums = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        GameOfLife_289 ofLife = new GameOfLife_289();
        ofLife.gameOfLife(nums);
        System.out.println("");
    }

    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               temp[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 核心
                int alive = isAlive(temp,i,j);
                // 规则1和规则3
                if ((temp[i][j] == 1) && (alive < 2 || alive >3)){
                    board[i][j] = 0;
                }
                // 规则4
                if (temp[i][j] == 0 && alive == 3){
                    board[i][j] = 1;
                }

            }
        }


    }

    /**
     * 判断某个节点的状态值
     * 计算8邻域的值
     * 并计算存活的细胞数
     */
    public int isAlive(int[][] nums, int i, int j){

        int m = nums.length;
        int n = nums[0].length;
        int alive = 0;
        // 八矩阵的下标
        int[] neighbors = {-1,0,1};

        /**
         *
         * 找到附近的8个点
         * 每个坐标 -1  本身 +1
         */
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                // 加一层判断，不统计当前数据本身
                if (!(neighbors[k] == 0 && neighbors[l] == 0)){
                    int rr = i + neighbors[k];
                    int cc = j + neighbors[l];
                    if ((rr < m && rr >=0) && (cc < n && cc >= 0)
                            && nums[rr][cc] == 1){
                        alive++;
                    }
                }

            }
        }

        return alive;

    }
}
