package com.gzd.leetcode.array;

/**
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，
 * 每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，
 * 返回在甲板 board 上放置的 战舰 的数量。
 * <p>
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，
 * 战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，
 * 其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 * <p>
 * 思路：
 * 1、遍历一行k列和k行一列
 * 按行遍历，如果当前位置有X,则 hang+1和lie+1,遍历到边界值
 * (错误)
 *
 * 开始题目没读懂
 * 每一行或则每一列 ，只要有一个X都算是一个战舰
 * 设计统计的是有个行列有X
 * 参考题解思路：
 * 1、如果(i,j)的位置是x,则把i和j所在的行列都 置为.
 * 2、剩下的如果还遍历到X,则说明是新的队列
 *
 * 解题关键：
 * 理解题意
 * 理解进阶提示的有用信息
 * 可以考虑使用额外空间，暴力解法
 *
 *
 * @author guozhongdong
 */
public class CountBattleships_419 {

    public static void main(String[] args) {
        char[][] nums = {{'.', '.', 'X', '.','.'}, {'.', 'X', '.', '.','X'}, {'.', '.', 'X', '.','X'}};
        CountBattleships_419 ships = new CountBattleships_419();
        //System.out.println(ships.countBattleships1(nums));
        System.out.println(ships.countBattleships(nums));
    }

    /**
     * 优化方法
     * 使用常数空间
     * 这个思路很奇妙，直接判断当前战舰的上方和左侧，有没有战舰，
     *  . . x . .
     *  . x . . x
     *  . . x . x
     *  输出4
     *
     *
     */
    public int countBattleships(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        //考虑临界值
        int count = 0;

        // 先在一行lie上找满足的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X'){
                    // 判断上方
                    if (i > 0 && board[i-1][j] == 'X'){
                        continue;
                    }
                    // 左侧列
                    if (j > 0 && board[i][j-1] == 'X'){
                        continue;
                    }
                    count++;

                }


            }
        }


        return count;
    }

    public int countBattleships1(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        //考虑临界值
        int count = 0;

        // 先在一行lie上找满足的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X'){
                    board[i][j] = '.';
                    // 列
                    for (int k = j+1; (k < n && board[i][k] == 'X'); k++) {
                        board[i][k] = '.';
                    }

                    // 行
                    for (int k = i+1; (k < m && board[k][j] == 'X'); k++) {
                        board[k][j] = '.';
                    }
                    count++;
                }


            }
        }


        return count;
    }
}
